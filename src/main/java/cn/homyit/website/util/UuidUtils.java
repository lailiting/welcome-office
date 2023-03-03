package cn.homyit.website.util;

import java.util.UUID;

/**
 * UUID工具
 *
 * @author mo
 */
public class UuidUtils {

    /**
     * 得到32位的uuid
     *
     * @return
     */
    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
