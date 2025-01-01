package xyz.shiqihao.common.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class IpAddressFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String isDev = req.getHeader("origin");
        if (isDev != null && isDev.equals("http://127.0.0.1:3000")) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

        String ip = req.getRemoteAddr();
        Set<String> allowedIPs = new HashSet<>();
        allowedIPs.add("81.68.104.220");
        allowedIPs.add("127.0.0.1"); // postman发起请求使用127.0.0.1，用localhost会被识别为ipv6
        if (!allowedIPs.contains(ip)) {
            log.info("unauthorized ip {}", ip);
            resp.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }
        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
