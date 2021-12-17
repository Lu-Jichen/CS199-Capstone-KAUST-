package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Errand;
import com.example.demo.entity.ErrandDTO;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface ErrandService extends IService<Errand> {

    List<Errand> getErrandList(Map<String,String> listRequest);

    String getErrandTypeNameById(int errandId);

    List<Errand> getErrandListErrandByUserId(int userId);

    List<Errand> getErrandListWorkByUserId(int userId);

    int receiveErrand(Map<String, Integer> item);

    int deleteErrandById(ErrandDTO errandDTO);

    int dropErrandById(Map<String, Integer> item);

    int doneErrandById(Map<String, Integer> item);

}
