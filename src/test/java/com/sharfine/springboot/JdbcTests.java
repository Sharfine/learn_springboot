package com.sharfine.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

@SpringBootTest
class JdbcTests {

    @Resource(name="oneJdbcTemplate")
    protected JdbcTemplate jdbcTemplate1;
    @Resource(name="twoJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;

    @Test
    public void test() throws Exception {
        jdbcTemplate1.update("insert into t_author(id, real_name, nick_name) values(?, ?, ?)", null, "aaa", "LiangGzone");
        jdbcTemplate2.update("insert into t_author(id, real_name, nick_name) values(?, ?, ?)", null, "aaa", "LiangGzone");
    }



}
