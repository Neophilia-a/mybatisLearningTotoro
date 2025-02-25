package com.totoro.mybatissourcecode.user;

import com.totoro.mybatissourcecode.entity.UserEntity;
import com.totoro.mybatissourcecode.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 功能：
 *
 * @author toroto
 * @date 2025/2/23/周日
 */
@SpringBootTest
public class UserTest {

    @Test
    public void test1() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        try (SqlSession sqlSession = factory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            for (UserEntity userEntity : mapper.queryAllList()) {
                System.out.println(userEntity);
            }
        }
    }
}
