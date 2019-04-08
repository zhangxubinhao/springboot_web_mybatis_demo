package com.example.demo.controller;

import com.example.demo.mapper.ProvinceMapper;
import com.example.demo.pojo.City;
import com.example.demo.pojo.Province;
import com.example.demo.service.CityService;
import com.example.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhang_xubin on 2019/3/29.
 *
 * @copyright It's not allowed to use this file content in any form include
 * reproduce and modify without the original author's permission
 */
@Controller
public class StudentController {


    @Autowired
    ProvinceService provinceService;

    @Autowired
    CityService cityService;

    @RequestMapping("/listStudent")
    public String listStudent(Model model){

        List<Province> provinces = provinceService.findAll();
        model.addAttribute("students",provinces);
        return "listStudent";
    }

    @RequestMapping("/listCity/{provinceId}")
    public String listCity(Model model, @PathVariable int provinceId){
        List<City> list = cityService.findByProvinceId(provinceId);
        model.addAttribute("students",list);
        return "listStudent";
    }
}
