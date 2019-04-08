package com.example.demo.service;

import com.example.demo.mapper.ProvinceMapper;
import com.example.demo.pojo.Province;
import com.example.demo.utils.DBTool;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhang_xubin on 2019/4/1.
 *
 * @copyright It's not allowed to use this file content in any form include
 * reproduce and modify without the original author's permission
 */
@Service
public class ProvinceService {
    public List<Province> findAll(){
        SqlSession sqlSession = DBTool.getSession();
        ProvinceMapper mapper = sqlSession.getMapper(ProvinceMapper.class);

        PageHelper.startPage(1,10);
        List<Province> list = mapper.findAll();
        return list;
    }
}
