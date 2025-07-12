package com.study.lease.common.utils;

import java.util.Random;

/**
 * ClassName: CodeUtil
 * Package: com.study.lease.common.utils
 * Description:
 *
 * @Author pupil
 * @Create 2025/5/5 20:11
 * @Version 1.0
 */
public class CodeUtil {
    public static String getRandomCode(Integer length){
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; ++i) {
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }
}
