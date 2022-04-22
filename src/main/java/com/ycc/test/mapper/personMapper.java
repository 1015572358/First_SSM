package com.ycc.test.mapper;

import com.ycc.test.pojo.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface personMapper {

    List<Person> getAll();

    int insertDemo(Person person);
}
