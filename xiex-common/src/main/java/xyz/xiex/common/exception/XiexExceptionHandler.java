package xyz.xiex.common.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.xiex.common.result.R;

/**
 * @author :xie xiex6027023673
 * Email: 1487471733@qq.com
 * Date: 2019/1/1
 * Time: 21:38
 * Describe:
 */
@ControllerAdvice
@Component
public class XiexExceptionHandler {

    @ExceptionHandler(XiexException.class)
    @ResponseBody
    public R xiexExceptionHandler(XiexException xe){

        return R.error(xe.getCode(),xe.getMessage(),xe.getData());
    }
}
