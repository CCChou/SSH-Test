package fortesting.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
    private HashUtil() {
    }
    
    public static byte[] hash(String algorithm, final byte[] data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.update(data);
        return md.digest();
    }
//    
//    public static void main(String[] args) throws NoSuchAlgorithmException {
//        byte[] data = "123456".getBytes();
//        System.out.println(new String(Hex.encodeHex(data)));
//        
//        System.out.println(new String(Hex.encodeHex(HashUtil.hash("SHA-256", data))));
//        
//    }
}
