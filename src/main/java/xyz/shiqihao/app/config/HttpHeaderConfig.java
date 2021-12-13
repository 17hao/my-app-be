package xyz.shiqihao.app.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.ZonedDateTime;

@Configuration
public class HttpHeaderConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HeaderInterceptor());
    }

    static class HeaderInterceptor extends HandlerInterceptorAdapter {
        private static final Logger LOGGER = LogManager.getLogger(HeaderInterceptor.class);

        // @Override
        // public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //     LOGGER.info("postHandle({}, {}, {}, {})", request.getCookies(), response.isCommitted(), handler, modelAndView);
        //     if (!response.isCommitted()) {
        //         response.addHeader("X-Timestamp", ZonedDateTime.now().toString());
        //     }
        // }

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            response.addHeader("X-Timestamp", ZonedDateTime.now().toString());
            return true;
        }
    }
}
