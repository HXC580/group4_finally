package com.example.group4.common.wx.service;


public interface WxMenuService {



    String wxPayUrl(Double totalFee, String outTradeNo, String signType, String GoodsName) throws Exception;


}
