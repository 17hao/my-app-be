package xyz.shiqihao.common.log;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        long startAt = System.currentTimeMillis();

        Object[] args = joinPoint.getArgs();

        String className = joinPoint.getTarget().getClass().getName();

        String methodName = joinPoint.getSignature().getName();

        String request = "{}";
        if (args.length > 1) {
            request = new ObjectMapper().writeValueAsString(args[0]);
        }

        Object result = joinPoint.proceed();

        long elapsedTime = System.currentTimeMillis() - startAt;

        log.debug("{}#{} request={} response={} execTime={}ms", className, methodName,
                request, new ObjectMapper().writeValueAsString(result), elapsedTime);

        return result;
    }
}
