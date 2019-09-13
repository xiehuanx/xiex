package xyz.xiex.common.exception;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import lombok.Data;
/**
 * @author :xie xiehuan6027023673
 * Email: 1487471733@qq.com
 * Date: 2019/1/1
 * Time: 21:16
 * Describe:
 */
@Data
public class XiexException extends RuntimeException {

    private static final long serialVersionUID=-1;

    private String id;

    private int code;

    private String message;

    private Object data;

    public XiexException(String message) {
        this(message,null);
    }
    public XiexException(String message, Object data) {
        this(500,message,data);
    }

    public XiexException(int code,String message, Object data) {
        super(message);
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(DateUtil.format(DateUtil.date(), "yyyyMMddHHmmss"));
        stringBuilder.append("-");
        stringBuilder.append(IdUtil.randomUUID());
        this.id = stringBuilder.toString();
        this.code=code;
        this.message = message;
        this.data = data;
    }
}
