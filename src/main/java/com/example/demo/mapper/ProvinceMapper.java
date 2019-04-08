package com.example.demo.mapper;

import com.example.demo.pojo.Province;
import com.example.demo.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by zhang_xubin on 2019/4/1.
 *
 * @copyright It's not allowed to use this file content in any form include
 * reproduce and modify without the original author's permission
 */

public interface ProvinceMapper {
    List<Province> findAll();
}
