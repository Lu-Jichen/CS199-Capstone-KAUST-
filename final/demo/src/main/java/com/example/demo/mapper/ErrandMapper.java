package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Errand;
import com.example.demo.entity.ErrandDTO;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ErrandMapper extends BaseMapper<Errand> {

//    @Select("SELECT t_question.*,t_student.`name` FROM t_question,t_student WHERE t_question.student_id=t_student.id")
    List<Errand> getErrandList(Map<String,String> listRequest);

    String getErrandTypeNameById(int errandId);

    List<Errand> getErrandListErrandByUserId(int userId);

    List<Errand> getErrandListWorkByUserId(int userId);

    int receiveErrandId(Map<String, Integer> item);

    int updateErrandStatus(Map<String, Integer> item);

    int dropErrandById(Map<String, Integer> item);

    int getErrandStatus(Map<String, Integer> item);

}
