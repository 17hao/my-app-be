package xyz.shiqihao.idgen;

import java.time.Instant;

import org.junit.Assert;
import org.junit.Test;
import xyz.shiqihao.idgen.IDGenerator;

public class IDGeneratorTest {
    @Test
    public void testGen() {
        long start = Instant.now().getEpochSecond();
        long id = IDGenerator.gen();
        for (int i = 0; i < 100000; i++) {
            long newID = IDGenerator.gen();
            Assert.assertTrue(newID > id);
        }
        System.out.println("time usage: " + (Instant.now().getEpochSecond() - start) + "s");
    }
}
