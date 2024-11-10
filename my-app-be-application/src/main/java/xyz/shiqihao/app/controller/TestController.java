package xyz.shiqihao.app.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPooled;
import xyz.shiqihao.app.config.AppConfig;
import xyz.shiqihao.common.IDGenerator;
import xyz.shiqihao.eshop.repo.dao.OrderItemDAO;
import xyz.shiqihao.eshop.repo.dao.OrderSummaryDAO;
import xyz.shiqihao.eshop.repo.model.OrderItemDO;
import xyz.shiqihao.eshop.repo.model.OrderSummaryDO;

@RestController
@AllArgsConstructor
public class TestController {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class AddressDTO implements Serializable {
        String country;
        String city;
    }

    @GetMapping("/test")
    public List<AddressDTO> test() {
        List<AddressDTO> res = new ArrayList<>();
        res.add(new AddressDTO("CN", "HZ"));
        res.add(new AddressDTO("USA", "LA"));
        return res;
    }

    @GetMapping("/lyj")
    public String lyj() {
        return "hello, lyj!";
    }

    @Resource
    @Qualifier("devConfig")
    private AppConfig devConfig;

    @Resource
    @Qualifier("prodConfig")
    private AppConfig prodConfig;


    @GetMapping("/config/{env}")
    public AppConfig config(@PathVariable("env") String env) {
        if (env.equals("prod")) {
            return prodConfig;
        }
        return devConfig;
    }

    private final JedisPooled redisClient;

    @PostMapping("/redis/kv")
    public void setRedisValue(@RequestBody Map<String, String> request) {
        for (Map.Entry<String, String> kv : request.entrySet()) {
            redisClient.set(kv.getKey(), kv.getValue());
        }
    }

    @GetMapping("/redis/kv/{key}")
    public Map<String, String> getRedisValue(@PathVariable("key") String key) {
        Map<String, String> res = new HashMap<>();
        res.put(key, redisClient.get(key));
        return res;
    }

    private final TransactionTemplate tx;

    private final OrderSummaryDAO orderSummaryDAO;

    private final OrderItemDAO orderItemDAO;

    @PostMapping("/tx/v1")
    public String txV1(@RequestParam Map<String, String> requestBody) {
        OrderSummaryDO orderSummaryDO = new OrderSummaryDO();
        orderSummaryDO.setId(IDGenerator.gen());
        orderSummaryDO.setCreator(1L);
        orderSummaryDO.setUpdater(1L);
        orderSummaryDO.setCreateTime(LocalDateTime.now());
        orderSummaryDO.setUpdateTime(LocalDateTime.now());
        orderSummaryDO.setUpdater(1L);
        orderSummaryDO.setDeleted(false);
        orderSummaryDO.setAmount(BigDecimal.valueOf(1.5));

        OrderItemDO orderItemDO = new OrderItemDO();
        orderItemDO.setId(IDGenerator.gen());
        orderItemDO.setOrderSummaryId(orderSummaryDO.getId());

        tx.execute(status -> {
            orderSummaryDAO.insert(orderSummaryDO);
            orderItemDAO.insert(orderItemDO);

            status.isRollbackOnly();

            return null;
        });

        return "";
    }
}
