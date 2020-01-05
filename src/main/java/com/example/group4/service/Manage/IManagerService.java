package com.example.group4.service.Manage;

import com.example.group4.bean.*;

import java.util.List;

public interface IManagerService {
    void ModifyStudent(Student student);
    List<Student> selectAllStudent();
    Student searchBy1();
    void freeze(int card_id,int manager_id);
    void abfreeze(int card_id,int manager_id);
    List<Mealcard> selectAllMealcard();
    Mealcard searchBy2();
    void modify (Manager manager);
    Manager selectManageown(int id);
    void logout(int student_id,int card_id,int manager_id);
    void  addBusiness(Business business);
    List<Business> selectAllBusiness();
    Business searchBy3();
    void modify(Dormitory dormitory);
    List<Dormitory> selectAllDormitory();
    void modifyBusiness(Business business);

}
