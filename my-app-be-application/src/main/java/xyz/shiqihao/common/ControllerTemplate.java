package xyz.shiqihao.common;

import lombok.extern.log4j.Log4j2;
import xyz.shiqihao.common.exception.BizException;

@Log4j2
public abstract class ControllerTemplate<T> {
    public abstract T biz();

    public Response<T> exec() {
        Response<T> res = new Response<>();
        try {
            T t = biz();
            res.setData(t);
            res.setCode("0");
            res.setMessage("ok");
        } catch (BizException e) {
            log.error("BizException errCode={} errMessage={}", e.getErrCode(), e.getErrMessage());
            res.setCode(e.getErrCode());
            res.setMessage("biz error");
        } catch (Exception e) {
            log.error("Exception errMessage={}", e.getMessage());
            res.setCode("COMMON_ERR_CODE");
            res.setMessage("system error");
        }
        return res;
    }
}
