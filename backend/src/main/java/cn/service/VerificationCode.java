package cn.service;

import java.util.HashMap;
import java.util.Map;

public class VerificationCode {
    private static Map<String, Long> codes = new HashMap<>();
    public static void storeCode(String code, long expirationTime) {
        codes.put(code, expirationTime);
    }

    public static boolean isCodeValid(String code) {
        if (codes.containsKey(code)) {
            long expirationTime = codes.get(code);
            if (System.currentTimeMillis() <= expirationTime) {
                return true;
            } else {
                codes.remove(code);
            }
        }
        return false;
    }
}
