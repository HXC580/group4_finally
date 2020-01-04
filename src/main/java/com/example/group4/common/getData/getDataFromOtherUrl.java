package com.example.group4.common.getData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class getDataFromOtherUrl {
//从外部网址获取返回的Json数据
//1.用在微信授权登录返回key数据


    public static String testJsonResult(Boolean needCheck,String url) throws IOException {
        String json = null;
        if(needCheck){
          URL connect = isConnect(url);

          if (null != connect){
              json = loadJson(connect.toString());
              System.out.println(json);
          }
      }
      else {
          json = loadJson(url);
          System.out.println(json);
      }
        return json;

    }


    private static synchronized URL isConnect(String urlStr) {
        URL url = null;
        HttpURLConnection connection = null;
        int counts = 0;
        if (urlStr == null || urlStr.length() <= 0) {
            return null;
        }
        while (counts < 5) {
            try {
                url = new URL(urlStr);
                connection = (HttpURLConnection) url.openConnection();
                int code = connection.getResponseCode();
                System.out.println(counts +" = "+code);
                if (code == 200) {
                    System.out.println("URL可用！");
                }
                break;
            } catch (Exception ex) {
                counts++;
                System.out.println("URL不可用，连接第 " + counts +"次");
                urlStr = null;
                continue;
            }
        }
        return url;
    }


    private static String loadJson(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            // 设置为utf-8的编码 才不会中文乱码
            BufferedReader in = new BufferedReader(new InputStreamReader(uc
                    .getInputStream(), "utf-8"));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

}
