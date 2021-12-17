package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Delivery;
import com.example.demo.entity.ErrandDTO;
import com.example.demo.entity.Pet;

public interface DeliveryService extends IService<Delivery> {

    Delivery getDeliveryById(int errandId);

    int updateDeliveryById(Delivery delivery);

    int insertDelivery(Delivery delivery);

    int deleteDeliveryById(ErrandDTO errandDTO);

}
