package xyz.shiqihao.account.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;
import xyz.shiqihao.account.request.RegisterAccountRequest;
import xyz.shiqihao.account.request.VerifyAccountRequest;
import xyz.shiqihao.account.service.AccountService;
import xyz.shiqihao.common.ControllerTemplate;
import xyz.shiqihao.common.HttpResponse;

@RestController
@RequestMapping(("/account"))
@AllArgsConstructor
@Log4j2
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/register")
    public HttpResponse<String> register(@RequestBody RegisterAccountRequest request) {
        return new ControllerTemplate<String>() {
            @Override
            public String biz() {
                long id = accountService.register(request.getName(), request.getPassword());
                return String.valueOf(id);
            }
        }.exec();
    }

    @PostMapping("/verify")
    public HttpResponse<String> verify(@RequestBody VerifyAccountRequest request, HttpServletResponse response) {
        return new ControllerTemplate<String>() {
            @Override
            public String biz() {
                String token = accountService.verify(request.getName(), request.getPassword());
                Cookie cookie = new Cookie("session_token", token);
                cookie.setHttpOnly(true);
                response.addCookie(cookie);
                return token;
            }
        }.exec();
    }

    @PostMapping("/auth")
    public HttpResponse<Boolean> auth(HttpServletRequest request) {
        return new ControllerTemplate<Boolean>() {
            @Override
            public Boolean biz() {
                Cookie sessionToken = WebUtils.getCookie(request, "session_token");
                if (sessionToken == null) {
                    log.warn("session_token not found");
                    return false;
                }
                return accountService.auth(sessionToken.getValue());
            }
        }.exec();
    }
}
