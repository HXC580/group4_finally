package com.example.group4.web.controller.Business;

import com.example.group4.bean.Business;
import com.example.group4.service.IMerchantService.IMerchantService;
import com.example.group4.service.StudentCardService.ICostBillService;
import com.example.group4.util.Message;
import com.example.group4.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@RestController
@RequestMapping("/business")
@Api(description = "商户管理")
public class MerchantController {
    @Autowired
    private IMerchantService merchantService;
    @Autowired
    private ICostBillService costBillService;

    @GetMapping("/detail")
    @ApiOperation(value = "查询商户信息")
    @ApiImplicitParam(name = "id",value = "商户id",dataType = "int", paramType = "query")
    public Message queById(int id){
        return MessageUtil.success(merchantService.queById(id));
    }

    @GetMapping("/update")
    @ApiOperation(value = "修改商户信息")
    public Message update(Business business){
        merchantService.saveOrUpdate(business);
        return MessageUtil.success();
    }

    @PostMapping("/selectCollectionRecords")
    @ApiOperation(value = "查询收款记录")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id",value = "商户id",paramType = "query",dataType = "int"),
//            @ApiImplicitParam(name = "startDateStr",value = "开始日期", dataType = "String"),
//            @ApiImplicitParam(name = "endDateStr", value = "结束日期", dataType = "String")
//    })
    public Message selectCollectionRecords(String startDateStr,String endDateStr, int id){
        //String转换成Date
        Date startDate = getDaDate(startDateStr+" 00:00:00");
        Date endDate = getDaDate(endDateStr+" 23:59:59");
        return MessageUtil.success(merchantService.selectCollectionRecords(startDate,endDate,id));
    }

    @GetMapping("/profit")
    @ApiOperation(value = "查询总收入")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id",value = "商户id",paramType = "query",dataType = "int"),
//            @ApiImplicitParam(name = "startDate",value = "开始日期"),
//            @ApiImplicitParam(name = "endDate", value = "结束日期")
//    })
    public Message profit(String startDateStr,String endDateStr,int id){
        Date startDate = getDaDate(startDateStr+" 00:00:00");
        Date endDate = getDaDate(endDateStr+" 23:59:59");
        return MessageUtil.success(merchantService.getProfit(startDate,endDate,id));
    }


    @GetMapping("/getProfitChart")
    @ApiOperation("获取收益图表信息")
    public Message getProfitChart(String selected){
        return MessageUtil.success(costBillService.getProfitChart(selected));
    }

    //工具类，判断返回是否为空
    public Message message(Object object,int code){
        if(object == null){
            return MessageUtil.error(200,"参数为空");
        }
        else {
            if(code==0)
                return MessageUtil.success();
            else
                return MessageUtil.success(object);
        }
    }

    //获取系统当前时间，字符串类型
    public static String getStrDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置为东八区
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Date newDate = new Date();
        String dateStr = sdf.format(newDate);
        return dateStr;
    }


    //获取系统当前时间Date类型，需要将字符串类型转成时间
    public static Date getDaDate( String dateStr){
        //将字符串转成时间
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date newDate=null;
        try {
            newDate = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }

}
