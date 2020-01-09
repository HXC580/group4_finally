package com.example.group4.util;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestJsoup {
    public static ArrayList test(String sid, String pwd) throws IOException {
//       String  url = "http://10.126.1.30/login?DDDDD=" + sid + "&upass=" + pwd + "&R1=0&R2=&R3=0&R6=0&para=00&0MKKey=123456&buttonClicked=&redirect_url=&err_flag=&username=&password=&user=&cmd=&Login=&v6ip=";
//        Document document = Jsoup.connect(url).get();
//        System.out.println(document);
//        document.getElementsByClass();

//
            Connection connect = Jsoup.connect("http://10.126.1.30/");
            Map<String, String> header = new HashMap<String, String>();
            header.put("Host", "10.126.1.30");
            header.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36");
            header.put("Accept", "text/html,application/xhtml+xml,application/xml;q = 0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
            header.put("Accept-Language", "zh-CN,zh;q=0.9");
            header.put("Connection", "keep-alive");
            header.put("Referer", "http://10.126.1.30/login?DDDDD="+sid+"&upass="+pwd+"&R1=0&R2=&R3=0&R6=0&para=00&0MKKey=123456&buttonClicked=&redirect_url=&err_flag=&username=&password=&user=&cmd=&Login=&v6ip=");
            header.put("Upgrade-Insecure-Requests","1");
            Connection data = connect.headers(header);
            Document document = data.get();
            String doc=String.valueOf(document);
         //   System.out.println(ss);
        String reg = "\\ntime='(.*?)';flow='(.*?)'.*?fee='(.*?)'";
        Matcher m = Pattern.compile(reg).matcher(doc);
        //System.out.println(m);
   //     String [] msg=new String [3];
        ArrayList<String> list=new ArrayList();
        while (m.find()) {
            for(int i =1;i<=3;i++)
            {
                String r = m.group(i);

                list.add(r);
               // msg[i]=r;
             // System.out.println(list.get(i));

            }
            System.out.println(list);
        }

       return list;


//        Elements elements = document.getElementsByTag("script");
//        for (Element element : elements) {
//            System.out.println(element.attr("type"));
//        }
//        System.out.println("------------------------------------------------------------------------------------");
//
//            System.out.println(document.html());

    }



    public static void main(String args[])
    {
        TestJsoup testJsoup = new TestJsoup();
        try {
            testJsoup.test("1716270145", "0145");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
