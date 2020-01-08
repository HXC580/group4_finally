package com.example.group4.web.controller.wx;

import com.example.group4.common.DataTypeTransform.JsonToMap;
import com.example.group4.common.DataTypeTransform.jsontouwei;
import com.example.group4.common.getData.getDataFromMysql;
import com.example.group4.common.getData.getDataFromOtherUrl;
import com.example.group4.common.setData.setDataToMysql;
import com.example.group4.config.loginconfig;
import com.example.group4.util.UserUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

@RestController
public class MainController {
    @GetMapping(value = {"login"})
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
        if (!res.trim().equals("") && !res.isEmpty()) {
//            sql = "UPDATE group4_3.wx SET `session_key` = '" + session_key + "' WHERE (`open_id` = '" + open_id + "');";
//            setDataToMysql.InsertOrUpdateDataToMysql(sql);
        } else {
            sql = "insert into  group4_3.wx (open_id,nick_name,avatarUrl,session_key)values('" + open_id + "','" + UserUtils.getNickname() + "','" + UserUtils.getAvatarUrl() + "','" + session_key + "');";
            setDataToMysql.InsertOrUpdateDataToMysql(sql);
            System.out.println("The frist login!!!");
        }

        returnDta = jsontouwei.jsontw(getDataFromMysql.getConnerct("SELECT * FROM mysc.user_data where open_id=\"" + open_id + "\""));
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Writer writer = response.getWriter();
        writer.write(returnDta);

    }

}
