package com.sharfine.springboot;

import com.sharfine.springboot.model.User;
import com.sharfine.springboot.service.EsService;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.index.reindex.BulkByScrollResponse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class EsTest {

    @Autowired
    private EsService userService;

    @Test
    public void testAll() throws InterruptedException {
        t1AddOne();
        t2AddBatch();
        Thread.sleep(1000);
        t3FindAll();
        t4search();
        t5deleteOne();
        t6deleteBatch();
        Thread.sleep(1000);
        t7FindAll();

    }

    @Test
    public void t1AddOne() {
        IndexResponse putOne = userService.putOne(new User(1, "中华人民共和国国歌",33));
        System.out.println("【1】putOne：" + putOne);
    }

    @Test
    public void t2AddBatch() {
        List<User> list = new ArrayList<>();
        list.add(new User(2, "东游记",59));
        list.add(new User(3, "鲁西西",25));
        BulkResponse putBatch = userService.putBatch(list);
        System.out.println("【2】putBatch：" + putBatch.status());
    }

    @Test
    public void t3FindAll() {
        System.out.println("【3】");
        List<User> res = userService.getAll();
        System.out.println("↓↓↓findAll");
        res.forEach(System.out::println);
        System.out.println("↑↑↑findAll");
    }

    @Test
    public void t4search() {
        System.out.println("【4】");
        List<User> searchByKey = userService.searchByKey("人中哈");
        searchByKey.forEach(System.out::println);
        System.out.println("-----");
        List<User> searchByKeyAge = userService.searchByKeyAge(5);
        searchByKeyAge.forEach(System.out::println);

        User user = userService.getByUserId(2);
        System.out.println("【4】getByUserId：" + user);
    }

    @Test
    public void t5deleteOne() {
        BulkByScrollResponse deleteById = userService.deleteById(1);
        System.out.println("【5】deleteById：" + deleteById.getStatus());
    }

    @Test
    public void t6deleteBatch() {
        List<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(3);
        BulkResponse deleteBatch = userService.deleteBatch(ids);
        System.out.println("【6】deleteBatch：" + deleteBatch.status());
    }

    @Test
    public void t7FindAll() {
        System.out.println("【7】");
        List<User> res = userService.getAll();
        System.out.println("↓↓↓findAll");
        res.forEach(System.out::println);
        System.out.println("↑↑↑findAll");
    }

}
