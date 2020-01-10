package com.example.group4.mapper;

import com.example.group4.bean.Mealcard;
import com.example.group4.bean.MealcardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MealcardMapper {
    long countByExample(MealcardExample example);

    int deleteByExample(MealcardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mealcard record);

    int insertSelective(Mealcard record);

    List<Mealcard> selectByExample(MealcardExample example);

    Mealcard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mealcard record, @Param("example") MealcardExample example);

    int updateByExample(@Param("record") Mealcard record, @Param("example") MealcardExample example);

    int updateByPrimaryKeySelective(Mealcard record);

    int updateByPrimaryKey(Mealcard record);
}