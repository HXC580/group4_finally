package com.example.group4.web.controller.Business;

import com.example.group4.bean.Business;
import com.example.group4.bean.Cost_bill;
import com.example.group4.service.IMerchantService.IMachineService;
import com.example.group4.service.IMerchantService.IMerchantService;
import com.example.group4.service.StudentCardService.ICostBillService;
import com.example.group4.util.Message;
import com.example.group4.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/business")
@Api(description = "商户管理")
public class MerchantController {
    @Autowired
    private IMerchantService merchantService;
    @Autowired
    private ICostBillService costBillService;
    @Autowired
    private IMachineService machineService;

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
    @ApiImplicitParam(name = "id",value = "机器id",dataType = "int",paramType = "query")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id",value = "商户id",paramType = "query",dataType = "int"),
//            @ApiImplicitParam(name = "startDateStr",value = "开始日期", dataType = "String"),
//            @ApiImplicitParam(name = "endDateStr", value = "结束日期", dataType = "String")
//    })
    public Message selectCollectionRecords(String startDateStr,String endDateStr, int id,
                                           @RequestParam(required = false,defaultValue = "1") int currentPage,
                                           @RequestParam(required = false,defaultValue = "5") int pageSize){
        //String转换成Date
        Date startDate = getDaDate(startDateStr+" 00:00:00");
        Date endDate = getDaDate(endDateStr+" 23:59:59");
        if (merchantService.selectCollectionRecords(startDate,endDate,id,currentPage,pageSize)==null){
            return MessageUtil.error(500,"数组越界,请检查起始页数是否正确。");
        }else {
            return MessageUtil.success(merchantService.selectCollectionRecords(startDate,endDate,id, currentPage,pageSize));
        }
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
    @ApiOperation("获取收益柱状图信息")
    public Message getProfitChart(String selected){
        return MessageUtil.success(costBillService.getProfitChart(selected));
    }

    @GetMapping("/downloadProfitSheet")
    @ApiOperation("下载收益报表")
    public void downloadProfitSheet(int busId,@RequestParam(required = false,defaultValue = "-1") int macId,
                                    HttpServletResponse response) throws IOException {
        List<Cost_bill> cost_bills = merchantService.downloadProfitSheet(busId,macId);
        String name = merchantService.queById(busId).getName();
        download(cost_bills,response,name);
    }

    public void download(List<Cost_bill> cost_bills, HttpServletResponse response,String name) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        //表头
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
        sheet.createRow(0).createCell(0).setCellValue(name+"收益报表");
        //表二
        XSSFRow row = sheet.createRow(1);
        row.createCell(0).setCellValue("学生卡号");
        row.createCell(1).setCellValue("消费金额");
        row.createCell(2).setCellValue("消费时间");
        row.createCell(3).setCellValue("机器序号");
        for (int i = 0; i < cost_bills.size(); i++) {
            XSSFRow row1 = sheet.createRow(i + 2);
            row1.createCell(0).setCellValue(cost_bills.get(i).getCardId());
            row1.createCell(1).setCellValue(cost_bills.get(i).getMoney());
            row1.createCell(2).setCellValue(DateToStr(cost_bills.get(i).getTime()));
            row1.createCell(3).setCellValue(cost_bills.get(i).getMachineId());
        }

        response.setHeader("content-Type","application/vnd.ms-excel");
        response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(name+"-收益报表.xlsx","utf-8"));
        workbook.write(response.getOutputStream());
    }

    @GetMapping("/selectMacByBusId")
    @ApiOperation(value = "根据商户id找机器")
    public Message selectMacByBusId(int busId){
        return MessageUtil.success(machineService.selectMacByBusId(busId));
    }

    //工具类，判断返回对象是否为空
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


    public static String DateToStr(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        return dateStr;
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
