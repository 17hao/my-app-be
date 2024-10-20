package xyz.shiqihao.account.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.shiqihao.account.request.RegisterAccountRequest;
import xyz.shiqihao.account.request.VerifyAccountRequest;
import xyz.shiqihao.account.service.AccountService;
import xyz.shiqihao.common.ControllerTemplate;
import xyz.shiqihao.common.Response;

@RestController
@RequestMapping(("/account"))
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/verify")
    public Response<String> verify(@RequestBody VerifyAccountRequest request) {
        return new ControllerTemplate<String>() {
            @Override
            public String biz() {
                return accountService.verify(request.getName(), request.getPassword());
            }
        }.exec();
    }

    @PostMapping("/register")
    public Response<String> register(@RequestBody RegisterAccountRequest request) {
        return new ControllerTemplate<String>() {
            @Override
            public String biz() {
                long id = accountService.register(request.getName(), request.getPassword());
                return String.valueOf(id);
            }
        }.exec();
    }
}
