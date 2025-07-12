package com.study.lease.common.login;

/**
 * ClassName: LoginUserHolder
 * Package: com.study.lease.common.login
 * Description:
 *
 * @Author pupil
 * @Create 2025/5/5 18:26
 * @Version 1.0
 */
public class LoginUserHolder {
    private static ThreadLocal<LoginUser> threadLocal = new ThreadLocal<>();
    public static void setLoginUser(LoginUser user) {
        threadLocal.set(user);
    }
    public static LoginUser getLoginUser() {
        return threadLocal.get();
    }
    public static void clear(){
        threadLocal.remove();
    }
}
