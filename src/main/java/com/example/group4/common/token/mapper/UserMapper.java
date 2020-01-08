package com.example.group4.common.token.mapper;

import com.example.group4.common.token.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author qiaoyn
 * @date 2019/06/14
 */
@Repository

@Mapper
public interface UserMapper {

    User findByUsername(String username,String type);

    User findUserById(String id,String type);

}

