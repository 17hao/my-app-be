package xyz.shiqihao.idgen;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.time.Instant;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ID generator based on Twitter snowflake alg.
 * 41-bit timestamp    10-bit node id    12-bit sequence no    1-bit extra bit
 * <p>
 * seata改进版
 * https://seata.apache.org/zh-cn/blog/seata-analysis-UUID-generator/
 * 1-bit extra bit    10-bit node id    41-bit timestamp    12-bit sequence no
 */
public class IDGenerator {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final int NUM_NODE_ID_BITS = 10;

    private static final int NUM_TIMESTAMP_BITS = 41;

    private static final int NUM_SEQ_NUM_BITS = 12;

    private static final long INITIAL_TIMESTAMP = Instant.now().toEpochMilli();

    private static final long CUSTOM_EPOCH = 1640966400000L; // 2022-01-01 00:00，这个值不能太大，太大会凑不满41-bit

    private static final int MAX_SEQ = (1 << NUM_SEQ_NUM_BITS) - 1;

    // 解决时钟漂移问题，时间戳和序列号作为连续的整体，序列号到达上限后不再等待下一秒，而是直接进位给时间戳加一
    // 时间戳只在系统启动阶段获取一次
    private static long timestamp = INITIAL_TIMESTAMP - CUSTOM_EPOCH;

    private static int seq = 0;

    /**
     * TODO:
     * 1. pressure testing
     * 2. concurrently update last timestamp and current timestamp
     * 3. mac addr mapping to node id
     */
    public static long gen() {
        long id = 0;

        // 1. generating epoch timestamp, millisecond precision
        // 改良版只在系统启动时获取一次时间戳，后续所有获取id的操作都基于这个时间戳递增

        // 2. generating node id based on mac address
        long nodeID;
        NetworkInterface macAddr = null;
        try {
            InetAddress ipAddr = InetAddress.getLocalHost();
            macAddr = NetworkInterface.getByInetAddress(ipAddr);
        } catch (UnknownHostException | SocketException | NullPointerException e) {
            // logging
        }
        if (macAddr == null) {
            nodeID = Math.abs("52:54:00:ee:d7:55".hashCode());
        } else {
            nodeID = Math.abs(macAddr.hashCode());
        }
        nodeID = nodeID << (64 - NUM_NODE_ID_BITS);
        nodeID = nodeID >>> (64 - NUM_NODE_ID_BITS); // nodeID只保留10-bit

        // 3. generating sequence number
        seq = (seq + 1) & MAX_SEQ; // e.g. 1022 & 1023 == 1022    1024 & 1023 == 0
        if (seq == 0) { // max seq number reached
            timestamp++;
        }
        timestamp = timestamp << (64 - NUM_TIMESTAMP_BITS);
        timestamp = timestamp >>> (64 - NUM_TIMESTAMP_BITS);

        String log = "%-10s=%-12d id=%d 0b(%64s)";

        id |= (nodeID << (NUM_SEQ_NUM_BITS + NUM_TIMESTAMP_BITS));
        LOGGER.debug(String.format(log, "nodeID", nodeID, id, Long.toBinaryString(id)));

        id |= (timestamp << NUM_SEQ_NUM_BITS);
        LOGGER.debug(String.format(log, "timestamp", timestamp, id, Long.toBinaryString(id)));

        id |= seq;
        LOGGER.debug(String.format(log, "seq", seq, id, Long.toBinaryString(id)));

        return id;
    }

    public static void main(String[] args) {
        System.out.println(IDGenerator.gen());
    }
}
