package com.example.group4.util;


public class UserUtils {
    public static String getNickname() {
        return nickname;
    }

    public static void setNickname(String nickname) {
        UserUtils.nickname = nickname;
    }

    public static String getCity() {
        return city;
    }

    public static void setCity(String city) {
        UserUtils.city = city;
    }

    public static String getProvince() {
        return province;
    }

    public static void setProvince(String province) {
        UserUtils.province = province;
    }

    public static String getAvatarUrl() {
        return avatarUrl;
    }

    public static void setAvatarUrl(String avatarUrl) {
        UserUtils.avatarUrl = avatarUrl;
    }



    private static String nickname;
    private static String city;
    private static String province;
    private static String avatarUrl;
    private static String open_id;

    public static String getOpen_id() {
        return open_id;
    }

    public static void setOpen_id(String open_id) {
        UserUtils.open_id = open_id;
    }


}
