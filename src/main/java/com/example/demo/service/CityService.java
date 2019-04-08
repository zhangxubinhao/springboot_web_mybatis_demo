package com.example.demo.service;

import com.example.demo.mapper.CityMapper;
import com.example.demo.mapper.ProvinceMapper;
import com.example.demo.pojo.City;
import com.example.demo.pojo.Province;
import com.example.demo.utils.DBTool;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhang_xubin on 2019/4/2.
 *
 * @copyright It's not allowed to use this file content in any form include
 * reproduce and modify without the original author's permission
 */
@Service
public class CityService {
    public List<City> findByProvinceId(int provinceId){
        SqlSession sqlSession = DBTool.getSession();
        CityMapper mapper = sqlSession.getMapper(CityMapper.class);
        List<City> list = mapper.findByProvinceId(provinceId);
        return list;
    }
}
