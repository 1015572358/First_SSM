package com.ycc.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ycc
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person implements Serializable {

    private static final long serialVersionUID = 8158728015237360355L;
    private int id;
    private String name;
    private String hobby;
}
