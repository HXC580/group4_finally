package com.example.group4.service.imerchantService;

import com.example.group4.bean.Machine;

import javax.crypto.Mac;
import java.util.List;

public interface IMachineService {

     List<Machine> findById(int id) throws RuntimeException;

    void editOrAddMac(Machine machine) throws RuntimeException;

    void delMac(int[] ids)throws RuntimeException;

    String recordBill(int cardId, double money, int machineId)throws RuntimeException;

    List<Machine> selectMacByBusId(int busId) throws RuntimeException;

    Machine findMacByMacId(int macId)throws RuntimeException;

    List<Machine> fuzzyQueMacByAddr(String word, int busId) throws RuntimeException;
}
