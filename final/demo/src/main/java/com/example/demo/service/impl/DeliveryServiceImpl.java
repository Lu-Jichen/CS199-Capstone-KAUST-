package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Delivery;
import com.example.demo.entity.ErrandDTO;
import com.example.demo.entity.Pet;
import com.example.demo.mapper.DeliveryMapper;
import com.example.demo.mapper.ErrandMapper;
import com.example.demo.mapper.PetMapper;
import com.example.demo.service.DeliveryService;
import com.example.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class DeliveryServiceImpl extends ServiceImpl<DeliveryMapper, Delivery> implements DeliveryService {

    @Autowired
    DeliveryMapper deliveryMapper;
    @Autowired
    ErrandMapper errandMapper;


    @Override
    public Delivery getDeliveryById(int errandId) {
        return deliveryMapper.getDeliveryById(errandId);
    }

    @Override
    public int updateDeliveryById(Delivery delivery) {
        Map<String, Integer> item = new HashMap<>();
        item.put("errandId", delivery.getErrandId());
        int status = errandMapper.getErrandStatus(item);
        if (status==2){
            return 0;
        }

        return deliveryMapper.updateDeliveryById(delivery);
    }

    @Override
    public int insertDelivery(Delivery delivery) {
        return deliveryMapper.insertDelivery(delivery);
    }

    @Override
    public int deleteDeliveryById(ErrandDTO errandDTO) {
        Map<String, Integer> item = new HashMap<>();
        item.put("errandId", errandDTO.getErrandId());
        int status = errandMapper.getErrandStatus(item);
        if (status==2){
            return 0;
        }

        return deliveryMapper.deleteDeliveryById(errandDTO);
    }
}
