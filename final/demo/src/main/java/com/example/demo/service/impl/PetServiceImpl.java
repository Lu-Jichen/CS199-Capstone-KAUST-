package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Errand;
import com.example.demo.entity.ErrandDTO;
import com.example.demo.entity.Pet;
import com.example.demo.mapper.ErrandMapper;
import com.example.demo.mapper.PetMapper;
import com.example.demo.service.ErrandService;
import com.example.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PetServiceImpl extends ServiceImpl<PetMapper, Pet> implements PetService {

    @Autowired
    PetMapper petMapper;
    @Autowired
    ErrandMapper errandMapper;


    @Override
    public Pet getPetById(int errandId) {
        return petMapper.getPetById(errandId);
    }

    @Override
    public int updatePetById(Pet pet) {
        Map<String, Integer> item = new HashMap<>();
        item.put("errandId", pet.getErrandId());
        int status = errandMapper.getErrandStatus(item);
        if (status==2){
            return 0;
        }

        return petMapper.updatePetById(pet);
    }

    @Override
    public int insertPet(Pet pet) {
        return petMapper.insertPet(pet);
    }

    @Override
    public int deletePetById(ErrandDTO errandDTO) {
        Map<String, Integer> item = new HashMap<>();
        item.put("errandId", errandDTO.getErrandId());
        int status = errandMapper.getErrandStatus(item);
        if (status==2){
            return 0;
        }

        return petMapper.deletePetById(errandDTO);
    }
}
