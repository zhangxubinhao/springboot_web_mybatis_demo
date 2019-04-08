package com.example.demo.mapper;

import com.example.demo.pojo.City;

import java.util.List;

/**
 * Created by zhang_xubin on 2019/4/2.
 *
 * @copyright It's not allowed to use this file content in any form include
 * reproduce and modify without the original author's permission
 */
public interface CityMapper {
    public List<City> findByProvinceId(int provinceId);
}
