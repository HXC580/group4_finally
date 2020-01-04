package com.example.group4.service.impl.MerchantServiceImpl;

import com.example.group4.bean.Machine;
import com.example.group4.bean.MachineExample;
import com.example.group4.mapper.MachineMapper;
import com.example.group4.service.IMerchantService.IMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineServiceImpl implements IMachineService {
    @Autowired
    private MachineMapper machineMapper;

    @Override
    public List<Machine> findById(int id) throws RuntimeException {
        MachineExample example = new MachineExample();
        example.createCriteria().andBusinessIdEqualTo(id);
        return machineMapper.selectByExample(example);
    }

    @Override
    public void editOrAddMac(Machine machine) throws RuntimeException {
        if(machine==null){
            new RuntimeException("参数错误");
        }
        if(machine.getId()==null){
            machineMapper.insert(machine);
        }
        else {
            machineMapper.updateByPrimaryKey(machine);
        }
    }

    @Override
    public void delMac(int id) throws RuntimeException {
        machineMapper.deleteByPrimaryKey(id);
    }


}
