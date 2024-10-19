package xyz.shiqihao.app.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import org.mybatis.dynamic.sql.where.condition.IsEqualTo;
import org.springframework.stereotype.Component;
import xyz.shiqihao.common.IDGenerator;
import xyz.shiqihao.app.infra.dal.OrderDO;
import xyz.shiqihao.app.infra.dal.OrderMapper;

import static xyz.shiqihao.app.infra.dal.OrderDODynamicSqlSupport.id;

@Component
@AllArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;

    public Long createOrder(BigDecimal amount) {
        long id = IDGenerator.gen();
        OrderDO order = new OrderDO();
        order.setId(id);
        order.setCreatetime(LocalDateTime.now());
        order.setUpdatetime(LocalDateTime.now());
        order.setDeleted(false);
        order.setCreator(1L);
        order.setUpdater(1L);
        order.setAmount(amount);
        orderMapper.insert(order);
        return order.getId();
    }

    public OrderDO queryOrder(long orderId) {
        return orderMapper.selectOne(c -> c.where(id, IsEqualTo.of(orderId))).orElseThrow();
    }
}
