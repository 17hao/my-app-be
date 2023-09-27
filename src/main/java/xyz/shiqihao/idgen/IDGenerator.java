package xyz.shiqihao.idgen;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.time.Instant;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * ID generator based on Twitter snowflake alg.
 * <p>
 * 41-bit timestamp        10-bit node id        12-bit sequence no        1-bit extra bit
 */
public class IDGenerator {
    private static int NODE_ID_BITS = 10;

    private static int SEQ_NUM_BITS = 13;

    private static long CUSTOM_EPOCH = 1672502400000L; // 2023-01-01 00:00

    private static int MAX_SEQ = (1 << 11) - 1;

    private static int seq = 0;

    private static long lastTimestamp = 0L;

    private static long timestamp() {
        return Instant.now().toEpochMilli() - CUSTOM_EPOCH;
    }

    /**
     * TODO:
     * 1. pressure testing
     * 2. concurrently update last timestamp and current timestamp
     * 3. mac addr mapping to node id
     * 4. wait until next millisecond
     */
    public static long gen() {
        long id = 0;

        // 1. generating epoch timestamp, millisecond precision
        long currentTs = timestamp();


        // 2. generating node id based on mac address
        NetworkInterface macAddr;
        try {
            InetAddress ipAddr = InetAddress.getLocalHost();
            macAddr = NetworkInterface.getByInetAddress(ipAddr);
        } catch (UnknownHostException | SocketException e) {
            throw new RuntimeException(e);
        }
        long nodeID = Math.abs(macAddr.hashCode());

        // 3. generating sequence number
        Lock lock = new ReentrantLock();
        lock.lock();
        if (currentTs == lastTimestamp) {
            seq = (seq + 1) & MAX_SEQ;
            if (seq == 0) {
                // max seq reached, wait until next millisecond
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                currentTs += 1;
            } else {
                seq = 0;
            }
        } else {
            seq = 0;
        }
        lock.unlock();

        id |= (currentTs << (NODE_ID_BITS + SEQ_NUM_BITS));
        Logger.getAnonymousLogger().info(String.format("step1 id=%s 0b(%s)", id, Long.toBinaryString(id)));

        id |= (nodeID << SEQ_NUM_BITS);
        Logger.getAnonymousLogger().info(String.format("step2 nodeID=%d id=%s 0b(%s)", nodeID, id, Long.toBinaryString(id)));

        id |= seq;
        Logger.getAnonymousLogger().info(String.format("step3 seq=%d id=%s 0b(%s)", seq, id, Long.toBinaryString(id)));

        return id;
    }

    public static void main(String[] args) {
        System.out.println(IDGenerator.gen());
    }
}
