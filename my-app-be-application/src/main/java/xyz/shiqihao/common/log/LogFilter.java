package xyz.shiqihao.common.log;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;
        log.info("method={}, remoteAddr={}, requestUri={}, requestBody={}",
                httpReq.getMethod(), httpReq.getRemoteAddr(), httpReq.getRequestURI(), getBody(httpReq));
        log.info(httpReq.getHeader("Origin"));
        chain.doFilter(servletRequest, servletResponse);
    }

    private String getBody(HttpServletRequest request) {
        return "";
        // try {
        //     return new String(request.getInputStream().readAllBytes());
        // } catch (IOException e) {
        //     log.error(e);
        // }
        // return "";
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
