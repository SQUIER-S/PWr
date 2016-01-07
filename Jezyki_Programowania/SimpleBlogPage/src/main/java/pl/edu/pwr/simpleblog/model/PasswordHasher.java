package pl.edu.pwr.simpleblog.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by SQUIER on 2015-12-20.
 */
public class PasswordHasher {

    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte[] bytes = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte aByte : bytes) {
            sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

}
