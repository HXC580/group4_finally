import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.request.AlipayTradeCancelRequest;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeCancelResponse;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import org.junit.jupiter.api.Test;

public class asd {
    public static final String ALIPAY_PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw+X4GNHQs2LZIu7eKmZ9AAwuCbLKRJWIWYGWWkdaF7egvlLlsCmktTdfKKwtkfLbd8U8iq8m8gQ+9KwrSYenIitsSrHJuTH1gVKp17DOcRW5Xxo5Bm0XWcvYs6W6f9QGzCXLKpswQZLkDeQLUd/Jw4VN+nc9OP+RuXgSY8aenNF9+VPOFhinpRXdPDB9D4y76uUMqD/KFEDYdnm/3XJnfunr0QXwgDJOFCWye2zB/UafI2F+Zh4eg0MrV+uauOsH+bNRgQxkt0O13ma10K3Q0jSU8Riu3jjCC7JWhlYjBKpwPUCZ01EA+u+Bu42IWZgb6L7Zc/KUj/kkJnCt6s3l/wIDAQAB/PQyOrCAWC4FF5pees/n6JhJhWVkYBkR+Ex9GO/G6a4lPAcdo/3l3LM1Q0oxtZJ55BoaMcPC2KXP492X5nfRBAukvvjdHUqUc2SUCP9TowxBo+60LpLXLdYer94ElBJTIBQn5g5o7bhmzGDa07i8CSUarJMPq1qF+XpXb4H4QqflfNTUDZdKRkC5AbiZXUw3FiKYqZIjuSwU6lsfy59sLcXNutCpW3ffXS8Ree4zlJCfrb35Pjjm1Ycd0PRWATou9B7euVc7cJjpoPBJzQIDAQAB";
    public static final String APP_PRIVATE_KEY="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDWMbxxl23g7OgpCwmLZmGKo2F/MvrXSw9tZi5YzOwXL3yKwXcNu05aqBuXMOtQIdcqqx389DI6sIBYLgUXml56z+fomEmFZWRgGRH4TH0Y78bpriU8Bx2j/eXcszVDSjG1knnkGhoxw8LYpc/j3Zfmd9EEC6S++N0dSpRzZJQI/1OjDEGj7rQuktct1h6v3gSUElMgFCfmDmjtuGbMYNrTuLwJJRqskw+rWoX5eldvgfhCp+V81NQNl0pGQLkBuJldTDcWIpipkiO5LBTqWx/Ln2wtxc260Klbd99dLxF57jOUkJ+tvfk+OObVhx3Q9FYBOi70Ht65VztwmOmg8EnNAgMBAAECggEACJ8r5K6hv6IJnk1RbwkJ+BinfgVBT5U348FvMCffgPdqXfN3pVfayY9mvOk9L5aNIKyOonX5557fK61+ivqtvufLf/NRUktIhQ29SW9awbw1F4bo/MeUi9tWe1HDXRgJdDOXMHVUhJhKqYnTGmr7CE3eXflSAlXmIJ216AcuZkY93t50F2JY+ZPvxbPZWKrEnPV262C0chxkgQ6X2Ng/8hnDFVSx5+goDp7CHGofqyEAregLwKYokmpEdlJM0Gezuu6cDycTzjMrDf+eRkHQ9eFmQWzqgQVDWTJ6CdqabON2E9o3ZVqod6Dh3hv7nN5mZBtXtk6Zee5OeoZKSwH3yQKBgQD+fXef/U8LPdgCdhll+unuT2Seu9t1tHZKXE3nmhHSA/uocoRMZ08cLfRdEP9fUaiQfZ/RvAaoROnn6Htq+yb93rAkRFc9OxWl0svzTnqNIMhVhgK+2g+s5bxdlYRmkllUhrl9ZNMnXueOh5sLfl4FITi3ZOxBBMxjIyQMOeGJmwKBgQDXdxDA6h+HLTJB1E39jrUUKOqo29Cu0KnqaYWUy277YrC78wjo/wAGPajaxYWiyoVicOv3vLz5EllCep2Z2FN8ksL9GtrKhOfk2LliciPNgUVQ/ssFwxTLsxSqszmupD6aagC9yixwOBQQAgyCz2ItsjooZ/ZGs/suZXLYOvmEtwKBgQDCSyIweKGHcKDhSC8d59H/yoeElOH5XFzPaudjggJG+BmDQmL1Pg5s8jzVbOu7Z0mtfuusocPnZi26i4jmZXcgbYrHNZHxQpHFd0mUqX7xDm1EtjqUYUGEfCUywbtC4ErpOK6XKIn5TgC1lZxuyvyXKAT4J0okXbh5m9OirfIeLwKBgQCKdtWpY8uHDyBw9YJ5I7BymCjVAw4Eicvn/I//owxbOHzjC7f6I4VcfVt5292ZVBSLwo2h0wSN+6Co/CszprVgJOBxz0QzSV3Mzwmzni4r7pshBdxqg4dlsFvjpvG2rY4dpWl8jeQo6aDa+LYZijRJsXN2a/j0Ts1ob4FyO9QF2QKBgCw/hgHvT+QPgpqaZrUPUNDa79JJ6G5AdmWcBmeNYG/Jge8O9jjsWJsEmEHTOZsCSwoeZyWqihkOrURa2smATha6gRpX5dSg5Yva5IKhueKNCtIrOkmov/opkWmSPLPvzSF0/OYBg4O6kY5DqUBHsIBxra+Os72n0YwJxNgr6gno";
    public static final String APPID= "2016102100731883";
    @Test
    public void rest()
    {

        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", APPID, APP_PRIVATE_KEY, "json", "UTF-8", ALIPAY_PUBLIC_KEY, "RSA2"); //获得初始化的AlipayClient
        AlipayTradePayRequest request = new AlipayTradePayRequest();
        AlipayTradePayModel model = new AlipayTradePayModel();


        model.setOutTradeNo(System.currentTimeMillis()+"");
        model.setSubject("Iphone6 16G");
        model.setTotalAmount("0.01");
        model.setAuthCode("281460177315146339");//沙箱钱包中的付款码
        model.setScene("bar_code");
        request.setBizModel(model);

        AlipayTradePayResponse response = null;
        try {
            response = alipayClient.execute(request);
            System.out.println(response.getBody());
            System.out.println(response.getTradeNo());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
    }

    //扫码支付
    @Test
    public void Test2()throws Exception{
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", APPID, APP_PRIVATE_KEY, "json", "UTF-8", ALIPAY_PUBLIC_KEY, "RSA2"); //获得初始化的AlipayClient
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();//创建API对应的request类
        request.setBizContent("{" +
                "    \"out_trade_no\":\"20150320010101002\"," +//商户订单号
                "    \"total_amount\":\"88.88\"," +
                "    \"subject\":\"Iphone6 16G\"," +
                "    \"store_id\":\"NJ_001\"," +
                "    \"timeout_express\":\"90m\"}");//订单允许的最晚付款时间
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        System.out.println(response.getBody());
        System.out.println(response.getQrCode()+"返回得到数据");
        //根据response中的结果继续业务逻辑处理
    }

    //查询账单
    @Test
    public void Test3()throws Exception{
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", APPID, APP_PRIVATE_KEY, "json", "UTF-8", ALIPAY_PUBLIC_KEY, "RSA2"); //获得初始化的AlipayClient
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();//创建API对应的request类
        AlipayTradePayModel model = new AlipayTradePayModel();

        model.setOutTradeNo("20150320010101002");
        request.setBizModel(model);
        AlipayTradeQueryResponse response = alipayClient.execute(request);//通过alipayClient调用API，获得对应的response类
        System.out.print(response.getBody());
        //根据response中的结果继续业务逻辑处理
    }


    //扫码退款
    @Test
    public void Test4()throws Exception{
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", APPID, APP_PRIVATE_KEY, "json", "UTF-8", ALIPAY_PUBLIC_KEY, "RSA2"); //获得初始化的AlipayClient
        AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();//创建API对应的request类
        AlipayTradePayModel model = new AlipayTradePayModel();
        model.setOutTradeNo("20150320010101002");
        request.setBizModel(model);
        AlipayTradeCancelResponse response = alipayClient.execute(request);//通过alipayClient调用API，获得对应的response类
        System.out.print(response.getBody());
        //根据response中的结果继续业务逻辑处理
    }
}
