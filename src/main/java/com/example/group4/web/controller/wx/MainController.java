//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.group4.web.controller.wx;

import com.example.group4.bean.Mealcard;
import com.example.group4.bean.MealcardExample;
import com.example.group4.common.DataTypeTransform.JsonToMap;
import com.example.group4.common.DataTypeTransform.MapToJSON;
import com.example.group4.common.DataTypeTransform.Paging;
import com.example.group4.common.DataTypeTransform.jsontouwei;
import com.example.group4.common.getData.getDataFromMysql;
import com.example.group4.common.getData.getDataFromOtherUrl;
import com.example.group4.common.setData.setDataToMysql;
import com.example.group4.config.loginconfig;
import com.example.group4.mapper.MealcardMapper;
import com.example.group4.util.TestJsoup;
import com.example.group4.util.UserUtils;
import com.example.group4.web.controller.student.BookController;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private BookController bookController = new BookController();
    private ArrayList list = new ArrayList();
    @Autowired
    private MealcardMapper mealcardMapper;

    public MainController() {
    }

    @GetMapping({"login"})
    public static void login(HttpServletRequest request, HttpServletResponse response, String nickname, String city, String code, String province, String avatarUrl) throws IOException {
        String returnDta = null;
        UserUtils.setAvatarUrl(avatarUrl);
        UserUtils.setProvince(province);
        UserUtils.setNickname(nickname);
        UserUtils.setCity(city);
        loginconfig.setCode(code);
        MultiValueMap<String, String> params = new LinkedMultiValueMap();
        params.add("appid", loginconfig.appID);
        params.add("secret", loginconfig.appSecret);
        params.add("js_code", loginconfig.code);
        params.add("grant_type", "authorization_code");
        String url = loginconfig.loginUrl + "?appid=" + loginconfig.appID + "&secret=" + loginconfig.appSecret + "&js_code=" + loginconfig.code + "&grant_type=authorization_code&connect_redirect=1 ";
        String rs = getDataFromOtherUrl.testJsonResult(false, url);
        Map a = JsonToMap.transfrom(rs);
        String open_id = a.get("openid").toString();
        String session_key = a.get("session_key").toString();
        String sql = "SELECT * FROM group4_3.wx where open_id=\"" + open_id + "\"";
        String res = jsontouwei.jsontw(getDataFromMysql.getConnerct(sql));
        if (res.trim().equals("") || res.isEmpty()) {
            sql = "insert into  group4_3.wx (open_id)values('" + open_id + "');";
            setDataToMysql.InsertOrUpdateDataToMysql(sql);
            System.out.println("The frist login!!!");
        }

        returnDta = jsontouwei.jsontw(getDataFromMysql.getConnerct("SELECT * FROM  group4_3.wx where open_id=\"" + open_id + "\""));
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Writer writer = response.getWriter();
        writer.write(returnDta);
    }

    @GetMapping({"selectBook_Paging"})
    public void getBookData(HttpServletRequest request, HttpServletResponse response, String key, String nowPageNumber) throws IOException {
        int N = Integer.parseInt(nowPageNumber);
        String sql = "select * from group4_3.book where name like '%" + key + "%' or author like '%" + key + "%'";
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Writer writer = response.getWriter();
        writer.write(this.getAAFromSql(sql, 10, N) + "");
    }

    @GetMapping({"selectLend_Paging"})
    public void selectLend_Paging(HttpServletRequest request, HttpServletResponse response, String id, String nowPageNumber) throws IOException {
        int N = Integer.parseInt(nowPageNumber);
        int ID = Integer.parseInt(id);
        String sql = "select * from group4_3.lend_list where card_id='" + this.SelectCard_idByStudentID(ID) + "'";
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Writer writer = response.getWriter();
        writer.write(this.getAAFromSql(sql, 10, N) + "");
    }

    @GetMapping({"selectReturn_Paging"})
    public void selectReturn_Paging(HttpServletRequest request, HttpServletResponse response, String id, String nowPageNumber) throws IOException {
        int N = Integer.parseInt(nowPageNumber);
        int ID = Integer.parseInt(id);
        String sql = "select * from  group4_3.return_list where card_id='" + this.SelectCard_idByStudentID(ID) + "'";
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Writer writer = response.getWriter();
        writer.write(this.getAAFromSql(sql, 10, N) + "");
    }

    @GetMapping({"selectwlan"})
    public void se(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<String> list = TestJsoup.test("1716270145", "0145");
        HashMap map = new HashMap();
        map.put("time", ((String)list.get(0)).trim());
        map.put("flow", Integer.parseInt(((String)list.get(1)).trim()) / 1024);
        map.put("money", Double.parseDouble(((String)list.get(2)).trim()) / 10000.0D);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(MapToJSON.mapToJson(map));
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Writer writer = response.getWriter();
        writer.write(arrayList2 + "");
    }

    @GetMapping({"selectCost_Paging"})
    public void selectCost_Paging(HttpServletRequest request, HttpServletResponse response, String id, String nowPageNumber) throws IOException {
        int N = Integer.parseInt(nowPageNumber);
        int ID = Integer.parseInt(id);
        String sql = "select * from  group4_3.cost_bill where card_id='" + this.SelectCard_idByStudentID(ID) + "'";
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Writer writer = response.getWriter();
        writer.write(this.getAAFromSql(sql, 10, N) + "");
    }

    @GetMapping({"selectRecharge_Paging"})
    public void selectRecharge_Paging(HttpServletRequest request, HttpServletResponse response, String id, String nowPageNumber) throws IOException {
        int N = Integer.parseInt(nowPageNumber);
        int ID = Integer.parseInt(id);
        String sql = "select * from  group4_3.recharge_bill where card_id='" + this.SelectCard_idByStudentID(ID) + "'";
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Writer writer = response.getWriter();
        writer.write(this.getAAFromSql(sql, 10, N) + "");
    }

    @GetMapping({"PageNumber"})
    public void PageNumber(HttpServletResponse response) throws IOException {
        int i = 0;
         i = Paging.getArraryListNumber(10, this.list);
        this.list = new ArrayList();
        Writer writer = response.getWriter();
        writer.write(i + "");
    }

    @GetMapping({"selectBookByBookId"})
    public void book(HttpServletRequest request, HttpServletResponse response, String book_id) throws IOException {
        int book_ID = Integer.parseInt(book_id);
        String sql = "select * from  group4_3.book where id='" + book_ID + "'";
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Writer writer = response.getWriter();
        writer.write(getDataFromMysql.getConnerct(sql) + "");
    }

    public ArrayList<ArrayList> getAAFromSql(String sql, int N, int nowPageNumber) {
        this.list.addAll(getDataFromMysql.getConnerct(sql));
        ArrayList<ArrayList> arrayList = Paging.getPageByArrayList(N, this.list);
        return (ArrayList)arrayList.get(nowPageNumber);
    }

    public int SelectCard_idByStudentID(int id) {
        MealcardExample mealcardExample = new MealcardExample();
        mealcardExample.createCriteria().andStudentIdEqualTo(id);
        int card_id = ((Mealcard)this.mealcardMapper.selectByExample(mealcardExample).get(0)).getId();
        return card_id;
    }
}
