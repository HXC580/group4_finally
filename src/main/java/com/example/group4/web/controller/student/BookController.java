package com.example.group4.web.controller.student;


import com.example.group4.bean.Book;
import com.example.group4.bean.Lend_list;
import com.example.group4.bean.Return_list;
import com.example.group4.bean.student.ex.BookEX;
import com.example.group4.bean.student.ex.Lend_listEX;
import com.example.group4.bean.student.ex.Return_listEX;
import com.example.group4.service.Student.IBookService;
import com.example.group4.util.GetQRCode;
import com.example.group4.util.Message;
import com.example.group4.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/Book")
@Api(description = "借阅管理")

public class BookController {

    @Autowired
    private IBookService iBookService ;

    @GetMapping("/displayAllLendList")
    @ApiOperation(value="获取全部借书信息")
    public Message displayAllLendList(){
        List<Lend_list> list=iBookService.displayAllLendList();
        return MessageUtil.success(list);

    }

    @GetMapping("/displayAllReturnList")
    @ApiOperation(value="获取全部还书信息")
    public Message displayAllReturnList(){
        List<Return_list> list=iBookService.displayAllReturnList();
        return MessageUtil.success(list);

    }

    @GetMapping("/selectAllLendList")
    @ApiOperation(value="获取全部借书详细信息")
    public Message selectAllLendList(){
        List<Lend_listEX> list=iBookService.selectAllLendList();
        return MessageUtil.success(list);

    }

    @GetMapping("/selectLendListByKey")
    @ApiOperation(value="根据关键字获取借书详细信息")
    public Message selectLendListByKey(String key){
        key="%"+key+"%";
        List<Lend_listEX> list=iBookService.selectLendListByKey(key);
        return MessageUtil.success(list);

    }


    @GetMapping("/selectAllReturnList")
    @ApiOperation(value="获取全部还书详细信息")
    public Message selectAllReturnList(){
        List<Return_listEX> list=iBookService.selectAllReturnList();
        return MessageUtil.success(list);

    }

    @GetMapping("/selectReturnListByKey")
    @ApiOperation(value="根据关键字获取还书详细信息")
    public Message selectReturnListByKey(String key){
        key="%"+key+"%";
        List<Return_listEX> list=iBookService.selectReturnListByKey(key);
        return MessageUtil.success(list);

    }
    @GetMapping("/selectAllBook")
    @ApiOperation(value="获取全部图书详细信息")
    public Message selectAllBook(){
        List<Book> list=iBookService.selectAllBook();
        return MessageUtil.success(list);

    }
    @GetMapping("/selectBookByKey")
    @ApiOperation(value="根据关键字获取图书详细信息")
    public List<Book> selectBookByKey(String key){
        key="%"+key+"%";
        List<Book> list=iBookService.selectBookByKey(key);
        return list;




    }
    @GetMapping("/payFine")
    @ApiOperation(value="根据借书Id付罚款")
    @ApiImplicitParam(name = "id",value = "借书id",paramType = "query",dataType = "int",required = true)
    public String payFineBy(int id){
        String url=iBookService.payFineById(id);

        return url;

    }
    @GetMapping("/selectLendListByStuId")
    @ApiOperation(value="根据学生Id查找借书记录")
    @ApiImplicitParam(name = "id",value = "借书id",paramType = "query",dataType = "int",required = true)
    public List<Lend_listEX> selectLendListByStuId(int id){
        List<Lend_listEX> lend_listEXES = iBookService.selectLendListByStuId(id);

        return lend_listEXES;

    }
    @GetMapping("/selectReturnListByStuId")
    @ApiOperation(value="根据学生Id查找还书记录")
    @ApiImplicitParam(name = "id",value = "借书id",paramType = "query",dataType = "int",required = true)
    public List<Return_listEX> selectReturnListByStuId(int id){
        List<Return_listEX> return_listEXES = iBookService.selectReturnListByStuId(id);

        return return_listEXES;

    }
    @GetMapping(value = "/image",produces = MediaType.IMAGE_JPEG_VALUE)
    @ApiOperation(value="根据图书Id生成二维码")
    public Message makeQRcode(HttpServletResponse response, int id){
        BookEX bookEX = iBookService.selectBookById(id);
        GetQRCode getQRCode=new GetQRCode();
        getQRCode.getQRCodePicture(bookEX,response);
        return MessageUtil.success();


    }


}
