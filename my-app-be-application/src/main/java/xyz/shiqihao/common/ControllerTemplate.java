package xyz.shiqihao.common;

import java.io.PrintWriter;
import java.io.StringWriter;

import lombok.extern.log4j.Log4j2;
import xyz.shiqihao.common.exception.AccountException;
import xyz.shiqihao.common.exception.BizException;

@Log4j2
public abstract class ControllerTemplate<T> {
    public abstract T biz();

    public HttpResponse<T> exec() {
        HttpResponse<T> res = new HttpResponse<>();
        try {
            T t = biz();
            res.setData(t);
            res.setCode("0");
            res.setMessage("ok");
        } catch (AccountException e) {
            log.error("AccountException errMessage={}", e.getErrMessage());
            res.setCode("INVALID_ARGS");
            res.setMessage("Login failed");
        } catch (BizException e) {
            log.error("BizException errCode={} errMessage={} stackTrace={}", e.getErrCode(), e.getErrMessage(), serializeStackTrace(e));
            res.setCode(e.getErrCode());
            res.setMessage(e.getErrMessage());
        } catch (Exception e) {
            log.error("Exception errMessage={} stackTrace={}", e.getMessage(), serializeStackTrace(e));
            res.setCode("COMMON_ERR_CODE");
            res.setMessage("system error");
        }
        return res;
    }

    private String serializeStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}
