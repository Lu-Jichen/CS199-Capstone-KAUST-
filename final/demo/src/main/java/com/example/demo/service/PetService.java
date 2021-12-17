package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Errand;
import com.example.demo.entity.ErrandDTO;
import com.example.demo.entity.Pet;

import java.util.List;

public interface PetService extends IService<Pet> {

    Pet getPetById(int errandId);

    int updatePetById(Pet pet);

    int insertPet(Pet pet);

    int deletePetById(ErrandDTO errandDTO);

}
