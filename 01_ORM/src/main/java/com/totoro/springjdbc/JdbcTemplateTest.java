package com.totoro.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 功能：
 *
 * @author toroto
 * @date 2025/2/6/周四
 */
public class JdbcTemplateTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDao dao = ac.getBean(UserDao.class);
        //dao.addUser();
        dao.query1();
        System.out.println("-----");
        dao.query2();
    }
}
