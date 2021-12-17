package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Delivery;
import com.example.demo.entity.ErrandDTO;
import com.example.demo.entity.Pet;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryMapper extends BaseMapper<Delivery> {

    Delivery getDeliveryById(int errandId);

    int updateDeliveryById(Delivery delivery);

    int insertDelivery(Delivery delivery);

    int deleteDeliveryById(ErrandDTO errandDTO);

}
