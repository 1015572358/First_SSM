package com.ycc.test.service;

import com.ycc.test.mapper.personMapper;
import com.ycc.test.pojo.Person;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HellowServiceImpl implements HellowService{
    @Resource
    private personMapper personMapper;
    @Override
    public String testAop() throws Exception{
        System.out.println("正常执行的方法");
        System.out.println(personMapper.getAll());
//        personMapper.insertDemo(new Person(2,"小聪仔","还是喜欢睡觉"));
        return "good";
    }
}
