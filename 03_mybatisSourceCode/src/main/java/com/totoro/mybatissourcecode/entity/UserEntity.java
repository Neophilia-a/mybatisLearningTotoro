package com.totoro.mybatissourcecode.entity;

import lombok.Data;
import lombok.ToString;

/**
 * 功能：用户实体类
 *
 * @author toroto
 * @date 2025/2/23/周日
 */
@Data
@ToString
public class UserEntity {

    private int id;

    private String userName;

    private String realName;

    private String passWord;

    private int age;

}
