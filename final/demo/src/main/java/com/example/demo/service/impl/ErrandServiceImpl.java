package com.example.demo.service.impl;

import com.example.demo.entity.Errand;
import com.example.demo.entity.ErrandDTO;
import com.example.demo.mapper.DeliveryMapper;
import com.example.demo.mapper.ErrandMapper;
import com.example.demo.mapper.PetMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.ErrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ErrandServiceImpl extends ServiceImpl<ErrandMapper, Errand> implements ErrandService {

    @Autowired
    ErrandMapper errandMapper;
    @Autowired
    PetMapper petMapper;
    @Autowired
    DeliveryMapper deliveryMapper;

    @Override
    public List<Errand> getErrandList(Map<String,String> listRequest) {
        return errandMapper.getErrandList(listRequest);
    }

    @Override
    public String getErrandTypeNameById(int errandId) {
        return errandMapper.getErrandTypeNameById(errandId);
    }

    @Override
    public List<Errand> getErrandListErrandByUserId(int userId) {
        return errandMapper.getErrandListErrandByUserId(userId);
    }

    @Override
    public List<Errand> getErrandListWorkByUserId(int userId) {
        return errandMapper.getErrandListWorkByUserId(userId);
    }

    @Override
    public int receiveErrand(Map<String, Integer> item) {
        int result1 = errandMapper.receiveErrandId(item);
        if (result1 == 0){
            return 0;
        }else{
            Map<String, Integer> updateItem = new HashMap<>();
            updateItem.put("errandId", item.get("errandId"));
            updateItem.put("status", 1);
            return errandMapper.updateErrandStatus(updateItem);
        }
    }

    @Override
    public int deleteErrandById(ErrandDTO errandDTO) {
        Map<String, Integer> item = new HashMap<>();
        item.put("errandId", errandDTO.getErrandId());
        int status = errandMapper.getErrandStatus(item);
        if (status==2){
            return 0;
        }
        item.put("status", 3);


//        if (errandDTO.getTypeName().equals("pet care")){
//            return petMapper.deletePetById(errandDTO);
//        }else if (errandDTO.getTypeName().equals("delivery")){
//            return deliveryMapper.deleteDeliveryById(errandDTO);
//        }
        errandMapper.updateErrandStatus(item);
        return 0;
    }

    @Override
    public int dropErrandById(Map<String, Integer> item) {
        int status = errandMapper.getErrandStatus(item);
        if (status==2){
            return 0;
        }
        item.put("status", 0);
        int result1 = errandMapper.dropErrandById(item);
        int result2 = errandMapper.updateErrandStatus(item);
        return result2;
    }

    @Override
    public int doneErrandById(Map<String, Integer> item) {
        item.put("status", 2);
        return errandMapper.updateErrandStatus(item);
    }


}
