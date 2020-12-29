package tjsse20.covid19logisticsblockchain.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

public class MD5Util {

    /**
     * MD5方法
     *
     * @param text 明文
     * @param key  密钥
     * @return 密文
     */
    public static String md5(String text, String key) {
        //加密后的字符串
        return DigestUtils.md5Hex(text + key);
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param key  密钥
     * @param md5  密文
     * @return true/false
     */
    public static boolean verify(String text, String key, String md5) {
        //根据传入的密钥进行验证
        String md5Text = md5(text, key);
        return md5Text.equalsIgnoreCase(md5);
    }

    public static String createId()
    {
        String id = UUID.randomUUID().toString();

        id = DEKHash(id) + "";

        int diff = 12 - id.length();
        String randStr = RandomStringUtils.randomAlphabetic(12);
        for (int i = 0; i < diff; i++)
        {
            int randIndex = (int) (Math.random() * randStr.length());
            int index = (int) (Math.random() * id.length());
            id = id.substring(0, index) + randStr.charAt(randIndex) + id.substring(index, id.length());
        }
        return id;
    }

    private static int DEKHash(String str)
    {
        int hash = str.length();

        for (int i = 0; i < str.length(); i++)
        {
            hash = ((hash << 5) ^ (hash >> 27)) ^ str.charAt(i);
        }

        return (hash & 0x7FFFFFFF);
    }
}
