package com.totoro.mybatissourcecode.mapper;

import com.totoro.mybatissourcecode.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 功能：
 *
 * @author toroto
 * @date 2025/2/23/周日
 */
//@Mapper
public interface UserMapper {
    List<UserEntity> queryAllList();
}
