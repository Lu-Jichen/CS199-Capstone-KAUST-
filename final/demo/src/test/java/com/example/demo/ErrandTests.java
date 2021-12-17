package com.example.demo;

import com.example.demo.entity.Errand;
import com.example.demo.entity.ErrandDTO;
import com.example.demo.entity.User;
import com.example.demo.mapper.DeliveryMapper;
import com.example.demo.mapper.ErrandMapper;
import com.example.demo.mapper.PetMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.ErrandService;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ErrandTests {

    @Autowired
    ErrandService errandService;

    @Autowired
    ErrandMapper errandMapper;
    @Autowired
    PetMapper petMapper;
    @Autowired
    DeliveryMapper deliveryMapper;


    @Test
    @DisplayName("Get Errand list")
    public void getErrandList(){
//        List<Errand> data = errandService.getErrandList();
//        System.out.println(data);
    }



    @Test
    @DisplayName("time")
    public void timeTest(){
        Date date = new Date();
        Long time = date.getTime();
        System.out.println(time);
        Date d = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(d));
    }

    @Test
    @DisplayName("time")
    public void deleteTest(){
        ErrandDTO test = new ErrandDTO();
        test.setErrandId(10);
        test.setTypeName("pet care");
        System.out.println(petMapper.deletePetById(test));
    }


}
