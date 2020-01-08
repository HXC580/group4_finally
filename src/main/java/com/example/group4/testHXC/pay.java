package com.example.group4.testHXC;

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

public class pay {


        public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnb4teeIU41CCSyhVhSKCw+AYyIsiPNtDsMQ0Nva8qxG1mFE0i3yKCCo3RtmwLqlMuXEx+4/55DdF8EnDlz0hayAo4s1fwOfEgm3/TpZVkE5oAh36YfXHByi07h7fiM73sTdmICIBbJKBwK6mdoPKXC9vgzWEwtwWlG/F/L+KNshGAaNoOobI9T7fv/IKVdJ7R80AGHb4aGVK1c+UJddKO/6Xpiht1o+wdrScvPNk0CavguQEKWWrK/cYGgzkzZuaEv+ZRGL+tfc182x9NY5BkevuJRB2G3byOMByj5867e9xi8XS4s/+i5twriRDcAedvDw2jged4R9lp3DwRwbWsQIDAQAB";
        public static final String APP_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCmDyaOVMaLJQlPpECyVD2TcU93ZTMrJm4DkSdUAkAaKFfvMGjrf48oqPpvRQBLKnw5Ag23L5E9h3MI5dbWffc4HGjy9tscFdGsADRmu7VrXxPEpFGk6O8L+SyudbXuZpdEG1db1WjNd76YdLxd6LJT/T4exB3A54U7LzF+87TLRhh6nH4SC/EykSGNX7opVdpzJeB+CBaDHI5LecWSy/jP3K6Zb/rhZB1VAOZnVJkFVbD1GPQSI4aDLOVwve2cztSGzuJtopTnREWpihVO9+vpD4ik38ZHJAG47O2cjDp+ul59I5UbuE7Xmx+AjtU88TsalPCw3qN87e1nofiUL0B9AgMBAAECggEASR2ypEi/gtSz3NU9h0eANUNW8gMlHIK3PerTnjG/d8T7st1l1Qs9RXHhksyW7IGwYIl+8IGJOcZB6FEK3zZne9VGgHQg1aTlxQ3yBKnxn20ljxequym011jHS6mYiXeyctJ3DIBSvOVUjlwX9GFY45JFn9ZKI33NM9n7uSIlILruyv4LVM68vXDExRoYMrR8s5+t3Ijcr8RrxJFOn/2UDCrWrjOGTc3X8ADO7jsytB/N+BLH7FvHgIYb6VGoSX7SZP4k1RkGvQRfTBIEDKBuNKNZDkC9m4OeuqIe3XyhULlLseChWujnfc7FW5vPuIC/n6mPtBJMB9OVSKR3p45UAQKBgQDOkxVrD2Q+54juMJAvV84OVSLZuAZk3NgVFpTTlxuhfrz7wcpG+8PbGQihn3G+9p2jNpQ+k022YQJbs9fr43nbhf+RMVnAXoC5w0s2rJ+/1uaTpiX3IgWA9kTOqCr1OVGpFCSIMKERy5/kcmbe2U1lVASfmxOm85JFLK/wyLVgoQKBgQDNynTrhiZeplNXb47EjEpE12z549OfHrLyfarukJ/Eve97i4tnF6AQ2yfmrdHzr08Q3jyZrn8MtNFbQW1EaSPlT00i7qiuTA3jVZc66UcdDPcVWDT79lZElzaxTfzs3LNVSM6ePWZH/PNTGBT7rIZzeWfL9eiCqCnuPkQAcutmXQKBgDRLmf17bQZbuReLpcTGdry8ItF5O+0m13EnQU/7jhwpKJCXc6zaqa96u+umoLYWWrvp4kehJOhJ0L4EXmIyOTQwzQ0lsDH5+p6MaSsTMnHvZnn0cuIIc9o8/hhPDGj+NMUX+1Oa8/u8T+MWbyJ1YpmHVpBNQwFd4iau9G+BcCFhAoGAV+ZnRIa7cuhGZu1+pNNrkbYWlTJMHQZG1y74SQg7RhT+6t1zAOjldO23QF/0csrp0cGrTtVq7Sl61yi+HF9wdq0FvKsGH9TahcT0YLRtrKnyDAruLsVMmeWg9eDi7OVkMER2BL8jJhKUeGSr6cgKcd5kiIkT9GMR7fJop2xuwf0CgYBGR7vS4kXDKpQt3vCKasulC+BIid89Xhi0Kum1N1janTF9KC3LM4O+By4pX0sFZ7/Y7HQMqVkQj+qXTzyJygqw8vgUbEb9UJJUPGwW7Bra23al/qDDy8CpnqSo1bZipEUdbVNEXU40Hh79r/ipcaohokizfoXo7EP/EftTwBbfnQ==";
        public static final String APPID =
                "2016102100732095";

        public String rest(String id)
        {

            AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", APPID, APP_PRIVATE_KEY,
                    "json", "UTF-8", ALIPAY_PUBLIC_KEY, "RSA2"); //获得初始化的AlipayClient
            AlipayTradePayRequest request = new AlipayTradePayRequest();
            AlipayTradePayModel model = new AlipayTradePayModel();
            model.setOutTradeNo(System.currentTimeMillis()+"");
            model.setSubject("Iphone6 16G");
            model.setTotalAmount("520");
            model.setAuthCode(id);//沙箱钱包中的付款码
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
            return response.getTradeNo()+""+response.getBody();
        }


        public void aaa() throws AlipayApiException {
//        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do","app_id","your private_key",
//                "json","GBK","alipay_public_key","RSA2");
            AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", APPID, APP_PRIVATE_KEY,
                    "json", "GBK", ALIPAY_PUBLIC_KEY, "RSA2"); //获得初始化的AlipayClient


            AlipayTradePayRequest request = new AlipayTradePayRequest();
            request.setBizContent("{" +
                            "    \"out_trade_no\":\"20150320010101001\","+
                            "\"scene\":\"bar_code\"," +
                            "\"auth_code\":\"281680847926168306\"," +
                            "\"product_code\":\"FACE_TO_FACE_PAYMENT\"," +
                            "\"subject\":\"Iphone6 16G\"," +
//                "\"buyer_id\":\"\"," +
                            "\"seller_id\":\"2088102180517760\"," +
                            "\"total_amount\":88.88," +
                            "\"trans_currency\":\"USD\"," +
                            "\"settle_currency\":\"USD\"," +
                            "\"discountable_amount\":8.88," +
                            "\"receipt_amount \":88.88,"+
                            "    \"timeout_express\":\"90m\"}"
            );
            AlipayTradePayResponse response = alipayClient.execute(request);
            if(response.isSuccess()){
                System.out.println("调用成功");
            } else {
                System.out.println("调用失败");
            }


        }

        public void Test252()throws Exception{
            AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do",
                    APPID, APP_PRIVATE_KEY, "json", "UTF-8", ALIPAY_PUBLIC_KEY, "RSA2"); //获得初始化的AlipayClient
            AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();//创建API对应的request类
            request.setBizContent("{" +
                    "    \"out_trade_no\":\"20150320010101001\"," +//商户订单号
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

        public void Test333()throws Exception{
            AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", APPID, APP_PRIVATE_KEY, "json", "UTF-8", ALIPAY_PUBLIC_KEY, "RSA2"); //获得初始化的AlipayClient
            AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();//创建API对应的request类
            AlipayTradePayModel model = new AlipayTradePayModel();

            model.setOutTradeNo("2020010722001486351000085369");
            request.setBizModel(model);
            AlipayTradeQueryResponse response = alipayClient.execute(request);//通过alipayClient调用API，获得对应的response类
            System.out.print(response.getBody());
            //根据response中的结果继续业务逻辑处理


        }


        //扫码退款

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
