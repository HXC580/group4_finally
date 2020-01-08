package com.example.group4.common.zfb;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.example.group4.common.zfb.config.AlipayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ZfbController {
    @GetMapping("/ZFB")

    public void zfb( HttpServletResponse response) throws IOException, AlipayApiException {
            AlipayClient alipayClient =
                    AlipayConfig.getAlipayClient();
            //设置请求参数
            AlipayTradePagePayRequest alipayRequest =
                    new AlipayTradePagePayRequest();

            AlipayTradePayModel model =
                    new AlipayTradePayModel();

            // 设定订单号 必须要写,且订单号不能重复，目前已经只是做测试，已经写死
            model.setOutTradeNo("441561558");

            // 设置订单金额
            model.setTotalAmount("0.01");
            // 订单名字
            model.setSubject("书籍订单");
            // 订单描述
            model.setBody(System.currentTimeMillis()+"");

            // 产品码
            model.setProductCode("FAST_INSTANT_TRADE_PAY");

            // 设置参数
            alipayRequest.setBizModel(model);

            // 设置回调地址
            alipayRequest.setReturnUrl(AlipayConfig.return_url);

            String result = alipayClient.pageExecute(alipayRequest).getBody();

            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(result);


    }
}
