package xyz.shiqihao.common.log;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        RequestWrapper httpReq = new RequestWrapper((HttpServletRequest) servletRequest);
        log.info("method={}, remoteAddr={}, requestUri={}, requestBody={}, headers={} cookies={}",
                httpReq.getMethod(), httpReq.getRemoteAddr(), httpReq.getRequestURI(), httpReq.getRequestBody(),
                serializeHttpHeaders(httpReq), serializeCookies(httpReq));
        chain.doFilter(httpReq, servletResponse);
    }

    private String serializeHttpHeaders(RequestWrapper httpReq) {
        Map<String, String> httpHeaders = new HashMap<>();

        Enumeration<String> httpHeaderNames = httpReq.getHeaderNames();
        if (httpHeaderNames == null) {
            return "";
        }

        for (; httpHeaderNames.hasMoreElements(); ) {
            String httpHeaderName = httpHeaderNames.nextElement();
            String httpHeader = httpReq.getHeader(httpHeaderName);
            httpHeaders.put(httpHeaderName, httpHeader);
        }

        try {
            return new ObjectMapper().writeValueAsString(httpHeaders);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    private String serializeCookies(RequestWrapper httpReq) {
        Cookie[] cookies = httpReq.getCookies();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(cookies);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
