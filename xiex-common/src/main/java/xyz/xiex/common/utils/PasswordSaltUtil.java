package xyz.xiex.common.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author :xie xiex6027023673
 * Email: 1487471733@qq.com
 * Date: 2019/1/31
 * Time: 21:38
 * Describe: 生成密码salt工具
 */
public class PasswordSaltUtil {

    /**
     * 密码固定salt
     */
    private final static String passwordSalt="xiexx";

    /**
     * 用于随机选的字符
     */
    private static final String BASE_CHAR = "abcdefghijklmnopqrstuvwxyz";
    /**
     * 用于随机选的数字
     */
    private static final String BASE_NUMBER = "0123456789";

    /**
     * 用于随机选的字符和数字
     */
    private static final String BASE_CHAR_NUMBER = BASE_CHAR + BASE_NUMBER;


    /**
     * 密码随机salt
     * @return
     */
    public static String  randomSalt(){
        String string =randomString(BASE_CHAR_NUMBER,8);
        final StringBuilder sb = new StringBuilder();
        for (int i=0;i<passwordSalt.length();i++){
            sb.append(passwordSalt.charAt(i));
            sb.append(string.charAt(i));
        }
        return sb.toString();

    }


    /**
     * 获得一个随机的字符串
     *
     * @param baseString 随机字符选取的样本
     * @param length 字符串的长度
     * @return 随机字符串
     */
    public static String randomString(String baseString, int length) {
        final StringBuilder sb = new StringBuilder();

        if (length < 1) {
            length = 1;
        }
        int baseLength = baseString.length();
        for (int i = 0; i < length; i++) {
            int number = ThreadLocalRandom.current().nextInt(baseLength);
            sb.append(baseString.charAt(number));
        }
        return sb.toString();
    }


}
