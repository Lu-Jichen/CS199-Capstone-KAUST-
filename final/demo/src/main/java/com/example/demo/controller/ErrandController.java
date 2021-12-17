package com.example.demo.controller;

import com.example.demo.common.Gender;
import com.example.demo.common.Result;
import com.example.demo.common.Status;
import com.example.demo.entity.*;
import com.example.demo.service.DeliveryService;
import com.example.demo.service.ErrandService;
import com.example.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class ErrandController {
    @Autowired
    ErrandService errandService;


    @Autowired
    PetService petService;
    @Autowired
    DeliveryService deliveryService;


    private void changeColName(Map<String, String> listRequest) {
        if (listRequest.get("orderCol").equals("createTime")){
            listRequest.put("orderCol","create_time");
        } else if (listRequest.get("orderCol").equals("typeName")){
            listRequest.put("orderCol","type_name");
        } else if (listRequest.get("orderCol").equals("statusDes")){
            listRequest.put("orderCol","status");
        }

        if (listRequest.get("searchPriceInterval") != null && !listRequest.get("searchPriceInterval").equals("")){
            String priceInterval = listRequest.get("searchPriceInterval");
            String[] sp = priceInterval.split("-");
            listRequest.put("minPrice", sp[0]);
            if (sp.length>1){
                listRequest.put("maxPrice",sp[1]);
            }
        }

        if (listRequest.get("searchStatus") != null && !listRequest.get("searchStatus").equals("")){
            int temp = Status.getId(listRequest.get("searchStatus"));
            listRequest.put("searchStatus", String.valueOf(temp));
        }
    }

    @PostMapping(value = "/api/errand/list")
    @CrossOrigin
    public Result getErrandList(@RequestBody Map<String,String> listRequest) {
        changeColName(listRequest);
        List<Errand> data = errandService.getErrandList(listRequest);
        data.stream().forEach(errand -> errand.setStatusDes());
        return new Result(200,"Get user list successfully!",data);
    }


    @PostMapping(value = "/api/errand/typeDetail")
    @CrossOrigin
    public Result getPetById(@RequestBody ErrandDTO errandDTO) {
        if (errandDTO.getTypeName().equals("")){
            errandDTO.setTypeName(errandService.getErrandTypeNameById(errandDTO.getErrandId()));
        }
        if (errandDTO.getTypeName().equals("pet care")){
            Pet data = petService.getPetById(errandDTO.getErrandId());
            data.setStatusDes();
            return new Result(200,"Get user list successfully!",data);
        }else if (errandDTO.getTypeName().equals("delivery")){
            Delivery data = deliveryService.getDeliveryById(errandDTO.getErrandId());
            data.setStatusDes();
            return new Result(200,"Get user list successfully!",data);
        }
        return new Result(400,"Error!","");
    }

    @PostMapping(value = "/api/errand/list/errand")
    @CrossOrigin
    public Result getErrandListErrandByUserId(@RequestBody User user) {
        List<Errand> data = errandService.getErrandListErrandByUserId(user.getUserId());
        data.stream().forEach(errand -> errand.setStatusDes());
        return new Result(200,"Get user list successfully!",data);
    }

    @PostMapping(value = "/api/errand/list/work")
    @CrossOrigin
    public Result getErrandListWorkByUserId(@RequestBody User user) {
        List<Errand> data = errandService.getErrandListWorkByUserId(user.getUserId());
        data.stream().forEach(errand -> errand.setStatusDes());
        return new Result(200,"Get user list successfully!",data);
    }

    @PostMapping(value = "/api/errand/receive")
    @CrossOrigin
    public Result receiveErrand(@RequestBody Map<String,String> receiveItem) {
        Map<String,Integer> item = new HashMap<>();
        for (String s : receiveItem.keySet()){
            item.put(s, Integer.valueOf(receiveItem.get(s)));
        }
        int result = errandService.receiveErrand(item);
        if (result!=0){
            return new Result(200,"Get user list successfully!","");
        }else{
            return new Result(300,"Error","");
        }
    }

    @PostMapping(value = "/api/errand/pet/update")
    @CrossOrigin
    public Result updatePetById(@RequestBody Pet pet) {
        int result = petService.updatePetById(pet);
        return new Result(200,"Get user list successfully!","");
    }

    @PostMapping(value = "/api/errand/pet/insert")
    @CrossOrigin
    public Result createPet(@RequestBody Pet pet) {
        Date date = new Date();
        Long time = date.getTime();
        Date d = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = (sdf.format(d));
        pet.setCreateTime(createTime);
        int result = petService.insertPet(pet);
        return new Result(200,"Get user list successfully!","");
    }

    @PostMapping(value = "/api/errand/delivery/update")
    @CrossOrigin
    public Result updateDeliveryById(@RequestBody Delivery delivery) {
        int result = deliveryService.updateDeliveryById(delivery);
        return new Result(200,"Get user list successfully!","");
    }

    @PostMapping(value = "/api/errand/delivery/insert")
    @CrossOrigin
    public Result createDelivery(@RequestBody Delivery delivery) {
        Date date = new Date();
        Long time = date.getTime();
        Date d = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = (sdf.format(d));
        delivery.setCreateTime(createTime);
        int result = deliveryService.insertDelivery(delivery);
        return new Result(200,"Get user list successfully!","");
    }

    @PostMapping(value = "/api/errand/delete")
    @CrossOrigin
    public Result deleteErrandById(@RequestBody ErrandDTO errandDTO) {
        int result = errandService.deleteErrandById(errandDTO);
        return new Result(200,"Get user list successfully!","");
    }

    @PostMapping(value = "/api/errand/drop")
    @CrossOrigin
    public Result dropErrandById(@RequestBody Map<String,String> dropItem) {
        Map<String,Integer> item = new HashMap<>();
        for (String s : dropItem.keySet()){
            item.put(s, Integer.valueOf(dropItem.get(s)));
        }
        int result = errandService.dropErrandById(item);
        return new Result(200,"Get user list successfully!","");
    }

    @PostMapping(value = "/api/errand/done")
    @CrossOrigin
    public Result doneErrandById(@RequestBody Map<String,String> dropItem) {
        Map<String,Integer> item = new HashMap<>();
        for (String s : dropItem.keySet()){
            item.put(s, Integer.valueOf(dropItem.get(s)));
        }
        int result = errandService.doneErrandById(item);
        return new Result(200,"Get user list successfully!","");
    }
}
