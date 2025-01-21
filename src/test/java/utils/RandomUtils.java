package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static String randomString (int len){
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
    public static String randomEmail () {
       return randomString(10) + "@qa.quru";
    }

    public static int randomInt (int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String tandomItem (String [] values){
        int index = randomInt(0, values.length - 1);
        return values[index];
    }
}
