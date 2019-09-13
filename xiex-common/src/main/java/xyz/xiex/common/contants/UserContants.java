package xyz.xiex.common.contants;

/**
 * @author :xie xiehuan6027023673
 * Email: 1487471733@qq.com
 * Date: 2019/1/2
 * Time: 21:04
 * Describe:
 */
public class UserContants {

    /**用户状态
     * NOMAL 正常
     * DELETE 被删除
     * FROZEN 冻结
     */
    public enum userStatus{
        NOMAL("1"),DELETE("0"),FROZEN("2");
        private String status;

        userStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }
}
