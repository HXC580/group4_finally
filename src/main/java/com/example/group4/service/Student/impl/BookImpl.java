package com.example.group4.service.Student.impl;

import com.example.group4.bean.Lend_list;
import com.example.group4.bean.Lend_listExample;
import com.example.group4.bean.Return_list;
import com.example.group4.bean.Return_listExample;
import com.example.group4.bean.student.ex.Lend_listEX;
import com.example.group4.mapper.Lend_listMapper;
import com.example.group4.mapper.Return_listMapper;
import com.example.group4.mapper.student.ex.BookEXMapper;
import com.example.group4.service.Student.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class BookImpl  implements IBookService {
    @Autowired
    private Lend_listMapper lend_listMapper;
    @Autowired
    private Return_listMapper return_listMapper;
    @Autowired
    private BookEXMapper bookEXMapper;


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
        return return_lists;
    }

    @Override
    public List<Lend_listEX> selectAllLendList() {
        List<Lend_listEX> lend_listEXES = bookEXMapper.selectAllLendList();
        for (Lend_listEX lend_listEX: lend_listEXES) {
            if (lend_listEX.getReturn_list() == null) {
                lend_listEX.setStatus("未还书");
            } else {
                lend_listEX.setStatus("已还书");
            }
            Calendar calendar1= Calendar.getInstance();
            Calendar calendar2= Calendar.getInstance();
            calendar1.setTime(lend_listEX.getReturn_list().getTime());
            calendar2.setTime(lend_listEX.getBorrowTime());
            long time=lend_listEX.getReturn_list().getTime().getTime()-lend_listEX.getBorrowTime().getTime();
            calendar2.add(Calendar.MONTH,1);

            if(calendar1.before(calendar2)){
                lend_listEX.setIsReturnBookTimeOut("否");
            }else{
                lend_listEX.setIsReturnBookTimeOut("是");
            }
            if(lend_listEX.getIsReturnBookTimeOut()=="否"){
                lend_listEX.setFine(0.00);
            }else{
                int days=(int)time/1000/60/60/24;
                Double fine=days*0.1;
                lend_listEX.setFine(fine);
            }


        }

        return lend_listEXES;
    }
}
