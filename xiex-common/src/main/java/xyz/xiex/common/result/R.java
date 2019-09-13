package xyz.xiex.common.result;

import lombok.Data;
import java.io.Serializable;

/**
 * @author :xie xiex6027023673
 * Email: 1487471733@qq.com
 * Date: 2019/1/2
 * Time: 11:36
 * Describe:
 */
@Data
public class R<E> implements Serializable {

    private int code;

    private String message;

    private E data;

    private Long timestamp;

    public R( int code, String message, E data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp=System.currentTimeMillis();
    }

    public static <E> R<E> success( int code, String message, E data){
        R r=new R(code,message,data);
        return r;
    }
    public static <E> R<E> success(String message,E data){
       return success(200,message,data);
    }

    public static <E> R<E> success(E data){
        return success("success",data);
    }

    public static <E> R<E> error(int code,String message,E data){
        R r=new R(code,message,data);
        return r;
    }

    public static <E> R<E> error(int code,String message){
        return error(code,message,null);
    }
    public static <E> R<E> error(int code){
        return error(code,"error");
    }
    public static <E> R<E> error(String message){
        return error(500,message);
    }
}
