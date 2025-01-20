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
import org.springframework.security.web.util.matcher.IpAddressMatcher;
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

        String remoteIp = req.getRemoteAddr();
        Set<String> allowedIPs = new HashSet<>();
        allowedIPs.add("127.0.0.1");
        allowedIPs.add("::1");
        allowedIPs.add("81.68.104.220");
        allowedIPs.add("2408:8240:e15:5d0::1/60");

        boolean match = false;
        for (String allowedIp : allowedIPs) {
            IpAddressMatcher ipAddressMatcher = new IpAddressMatcher(allowedIp);
            if (ipAddressMatcher.matches(req.getRemoteAddr())) {
                match = true;
                break;
            }
        }

        if (match) {
            chain.doFilter(servletRequest, servletResponse);
        } else {
            log.info("unauthorized ip {}", remoteIp);
            resp.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
