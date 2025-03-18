package com.shop.living.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

    // ✅ 비밀번호 해싱
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] byteData = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : byteData) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    // ✅ 비밀번호 검증
    public static boolean checkPassword(String inputPwd, String storedPwd) throws NoSuchAlgorithmException {
        return hashPassword(inputPwd).equals(storedPwd);
    }
}
