package com.example.group4.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

public class AlipayConfig {
    /**
     * 服务网关   沙箱环境都是这个
     */
    public static String serverUrl = "https://openapi.alipaydev.com/gateway.do";

    /**
     * 应用id  后期可以替换成自己的id
     */
    public static String appId = "2016101900723901";

    /**
     *  用户私钥   后期替换成自己的私钥
     */
    public static String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCT7JBzFqJTjvbnU2yFn/0OFggN/DWmez2LT1OfV+RQu1cmKbXTDLdNDJdmSxkxt3Lj2i9NguwZ87yL4X/AvDRIonhvtgYO5tQqqwkGPniO9RXb3htOMMfHUDqFUm/z05mn7JgfER+ggH2z57gcckdlwYq6IC16LUuFNPsxhHVl/oioiVPByShpul/i/3BXE/sG+EVFDYCJvMZmw8NXAjXtmHg/zPI++1ajezaskieeJjAOP6V1y8pDetNhsm+zVHLcnXCqLfe50skBb6t+O75nGcSEtQb3LJZJEHs0f4/Kc+JdzJl6F3lyy2m0zxJnnZ2WBbaBr1oVDfT3YI7zFuojAgMBAAECggEARijx6mRV4aPxX46l7ksPz1qLv3ZcS/YwHp8lXnJljBUPJL6ryspBNn4+YPpFnNsR1xhpTy5FpZmBWCdAXL3nXnwQ+4suHGtHPmWZBikjLUr5bytNcCya1OIsn4eWKeO3AXqqPDH2+j13YZkKLhPV4WGG1vjkGQrawvd6HOZieFkkFDPNJduJhsXAGrNMRxT7Iiap6axw61AQjyVEuzJ1USrjo0i8q40wvonsI6OinzXATHkCXmnOc1hjJiW0SvZq1lpcyMPbfcB9ltMbJ9O8vBVqw/AWhP3GcpOSMrI83BfteeInt2EqZm9hhnbGCFmzqT0Q5PY5fK26fuzT8u4F4QKBgQDXW0S51OpP0Fa6nSL7fXE/IVZpmwrzyBzJ67MeBRDf1WEqKpJfNvm5u/Q6pfo5sOKAG6mv62xvRZEBcchVFW4lbsauEZWQ7mHifpNbfHYJYm3LV79kncmedB8KxVOFHLtGxnqC/TRwBGnTbbpm/nA8sHusWRrnUgAyx6OwnC3x7QKBgQCv112xVYZVVdRBBg41cr6NdFwEtVKtxGrAXcN+iteJp0knSocJEEronBDcnkPOrGWGF3id0W3X3oc77UWh6H5A7/Qvcmi7HZFrrCHnno6fLbN1/Ed6Lsnz18J0w5nxdUAW4b3uFkuM4IOVovTPQpH8fsBHe06WxxRJvdOTVI4KTwKBgQCmeToOQQWD/zQb+76AE/9H4thuuFhmDKoceOQ0b4wUy1jaBKCzk8bFigKIl6dvk0nz5+5rPBzNg0RNjoxjITbNHu3cv2ET8QKf2GLG1NZV+M2Q49rix4qEv5UDeXhPrN8kHee0fFFdyjuYIfl3BnbyoyZnG1ZNvLjEiEkEDCcEHQKBgFqAy31RWpGjWlqZRkjmJQNjR1U5CjPbq2IVIGCKD4OO8Uziw/u7QgLVCKy0XIwMGTjZ7b+0ogeARjRm2/cIVasQlaqyBQuBnW5AqzauWhO9jueEEDnnyRPTEgfNAPfQ9EqSp5HaMcpxZ+hldgES71Z42ngwE/PwxRVrOXFUDMNrAoGAKI/cu9ggoBUP7frdCn5v9jvJGnvxcYkpp2LYHED9lofTNi933ctX6y9hUdIeedn9XbjJ8oy1dDn6Fx6rUdjv3/G29JLlQKNVDIurNJC3TIO0Gf18HelSuUxNfZ/5B1kT3jy4FU2Zn6I/aaQNtsTu4OXzUAXeo1X2r0uVpZMwtAw=";

    /**
     *  发送数据的格式 目前只能为json
     */
    public static String format = "json";

    /**
     *  设置字符集编码 目前只能为utf-8
     */
    public static String charset = "utf-8";

    /**
     *  支付宝公钥 后期替换成自己的支付宝公钥
     */
    public static String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk+yQcxaiU47251NshZ/9DhYIDfw1pns9i09Tn1fkULtXJim10wy3TQyXZksZMbdy49ovTYLsGfO8i+F/wLw0SKJ4b7YGDubUKqsJBj54jvUV294bTjDHx1A6hVJv89OZp+yYHxEfoIB9s+e4HHJHZcGKuiAtei1LhTT7MYR1Zf6IqIlTwckoabpf4v9wVxP7BvhFRQ2AibzGZsPDVwI17Zh4P8zyPvtWo3s2rJInniYwDj+ldcvKQ3rTYbJvs1Ry3J1wqi33udLJAW+rfju+ZxnEhLUG9yyWSRB7NH+PynPiXcyZehd5cstptM8SZ52dlgW2ga9aFQ3092CO8xbqIwIDAQAB";

    /**
     *  支付宝签名 目前是 RSA2
     */
    public static String signType = "RSA2";

    /**
     *  页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    public static String return_url = "http://localhost:8081/estore/index.jsp";

    public static AlipayClient getAlipayClient() {
        // 获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.serverUrl, AlipayConfig.appId, AlipayConfig.privateKey, AlipayConfig.format, AlipayConfig.charset, AlipayConfig.publicKey, AlipayConfig.signType);
        return alipayClient;
    }

}