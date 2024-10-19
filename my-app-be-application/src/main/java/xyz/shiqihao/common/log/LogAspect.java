package xyz.shiqihao.common.log;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class LogAspect {
    @Pointcut("execution(public * xyz.shiqihao.*.controller.*.*(..))")
    private void controller() {
    }

    @Around(value = "controller()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        log.debug(">> {} - {}", methodName, new Gson().toJson(args));
        Object result = joinPoint.proceed();
        log.debug("<< {} - {}", methodName, new Gson().toJson(result));
        return result;
    }
}
