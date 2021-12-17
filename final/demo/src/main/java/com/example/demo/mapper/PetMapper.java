package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Errand;
import com.example.demo.entity.ErrandDTO;
import com.example.demo.entity.Pet;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetMapper extends BaseMapper<Pet> {

    //    @Select("SELECT t_question.*,t_student.`name` FROM t_question,t_student WHERE t_question.student_id=t_student.id")
    Pet getPetById(int errandId);

    int updatePetById(Pet pet);

    int insertPet(Pet pet);

    int deletePetById(ErrandDTO errandDTO);

}
