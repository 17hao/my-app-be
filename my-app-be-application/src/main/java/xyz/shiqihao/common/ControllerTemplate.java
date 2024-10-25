package xyz.shiqihao.common;

import xyz.shiqihao.common.exception.BizException;

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
            res.setCode(e.getErrCode());
            res.setMessage(e.getErrMessage());
        } catch (Exception e) {
            res.setCode("COMMON_ERR_CODE");
            res.setMessage(e.getMessage());
        }
        return res;
    }
}
