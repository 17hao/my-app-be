package xyz.shiqihao.app.controller;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.shiqihao.common.ControllerTemplate;
import xyz.shiqihao.common.HttpResponse;
import xyz.shiqihao.app.form.OrderForm;
import xyz.shiqihao.app.service.OrderService;

@RestController
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/orders")
    public HttpResponse<String> createOrder(@RequestBody OrderForm orderForm) {
        return new ControllerTemplate<String>() {
            @Override
            public String biz() {
                BigDecimal amount = new BigDecimal(orderForm.getAmount());
                long orderId = orderService.createOrder(amount);
                return String.valueOf(orderId);
            }
        }.exec();
    }
}
