package com.example.group4.service.Student.impl;

import com.example.group4.bean.*;
import com.example.group4.bean.student.ex.Lend_listEX;
import com.example.group4.bean.student.ex.Return_listEX;
import com.example.group4.mapper.BookMapper;
import com.example.group4.mapper.Lend_listMapper;
import com.example.group4.mapper.Return_listMapper;
import com.example.group4.mapper.ex.PoEXMapper;
import com.example.group4.mapper.student.ex.BookEXMapper;
import com.example.group4.service.Student.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private Lend_listMapper lend_listMapper;
    @Autowired
    private Return_listMapper return_listMapper;
    @Autowired
    private BookEXMapper bookEXMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private PoEXMapper poEXMapper;



    public void setLendListEX(Lend_listEX lend_listEX) {

     if(lend_listEX.getReturn_list()==null)
     {
        lend_listEX.setStatus("未还书");
    } else {
        lend_listEX.setStatus("已还书");
    }
    Calendar calendar1 = Calendar.getInstance();
    Calendar calendar2 = Calendar.getInstance();
    calendar1.setTime(lend_listEX.getReturn_list().getTime());
    calendar2.setTime(lend_listEX.getBorrowTime());
    long time = lend_listEX.getReturn_list().getTime().getTime() - lend_listEX.getBorrowTime().getTime();
    calendar2.add(Calendar.MONTH,1);

    if(calendar1.before(calendar2))
    {
        lend_listEX.setIsReturnBookTimeOut("否");
    }else {
        lend_listEX.setIsReturnBookTimeOut("是");
    }
    if(lend_listEX.getIsReturnBookTimeOut()=="否")
    {
        lend_listEX.setFine(0.00);
    }else {
        int days = (int) (time - 1000 * 60 * 60 * 24 * 30) / 1000 / 60 / 60 / 24;
        Double fine = days * 0.1;
        lend_listEX.setFine(fine);
    }

 }


    @Override
    public List<Lend_list> displayAllLendList() {
        Lend_listExample lend_listExample=new Lend_listExample();
        List<Lend_list> lend_lists = lend_listMapper.selectByExample(lend_listExample);

            return lend_lists;

    }

    @Override
    public List<Return_list> displayAllReturnList() {
        Return_listExample return_listExample = new Return_listExample();
        List<Return_list> return_lists = return_listMapper.selectByExample(return_listExample);
            System.out.println(return_lists);
            return return_lists;


    }

    @Override
    public List<Lend_listEX> selectAllLendList() {
        List<Lend_listEX> lend_listEXES = bookEXMapper.selectAllLendList();
        for (Lend_listEX lend_listEX: lend_listEXES) {
              setLendListEX(lend_listEX);
        }


            return lend_listEXES;


    }

    @Override
    public List<Lend_listEX> selectLendListByKey(String key) {
        key="%"+key+"%";
        List<Lend_listEX> lend_listEXES = bookEXMapper.selectLendListByKey(key);
        for (Lend_listEX lend_listEX: lend_listEXES) {
            setLendListEX(lend_listEX);
        }

            return lend_listEXES;

    }
    @Override
    public String payFineById(int id) {
        Lend_listEX lend_listEX = bookEXMapper.selectLendListById(id);
        setLendListEX(lend_listEX);
        Po po=new Po();
        po.setPrice(String.valueOf(lend_listEX.getFine()));
        po.setPoState("待支付");
        po.setSysName("借书超期费用");
        po.setPrdName("借书超期费用");
        System.out.println(po);
        poEXMapper.insertBookFine(po);
        int  poid=po.getPoNo();
        String url="http://127.0.0.1:8888/From?PO_NO="+poid;
        return  url;

    }





    @Override
    public  List<Lend_listEX> selectLendListByStuId(int sid) {
        int CardId=bookEXMapper.selectCardIdByStuId(sid);
        List<Lend_listEX> lend_listEXES = bookEXMapper.selectLendListByCardId(CardId);
        //       Lend_listEX lend_listEX = bookEXMapper.selectLendListById(id);

        return lend_listEXES;
    }

    @Override
    public List<Return_listEX> selectReturnListByStuId(int sid) {
        int CardId=bookEXMapper.selectCardIdByStuId(sid);
        List<Return_listEX> return_listEXES = bookEXMapper.selectReturnListByCardId(CardId);

        return return_listEXES;
    }


/*    @Override
    public void (int id) {
        Lend_listEX lend_listEX = bookEXMapper.selectLendListById(id);


    }*/












    @Override
    public List<Return_listEX> selectAllReturnList() {
        List<Return_listEX> return_listEXES=bookEXMapper.selectAllReturnList();


            return return_listEXES;

    }

    @Override
    public List<Return_listEX> selectReturnListByKey(String key) {
        List<Return_listEX> return_listEXES=bookEXMapper.selectReturnListByKey(key);

            return return_listEXES;

    }

    @Override
    public List<Book> selectAllBook() {
        BookExample bookExample= new BookExample();
        List<Book> books = bookMapper.selectByExample(bookExample);

        return books;

    }

    @Override
    public List<Book> selectBookByKey(String key) {
        List<Book> books = bookEXMapper.selectBookByKey(key);

            return books;

    }
}
