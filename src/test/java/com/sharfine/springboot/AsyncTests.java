package com.sharfine.springboot;

import com.sharfine.springboot.service.AsyncTaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Future;

@SpringBootTest
class AsyncTests {

    @Autowired
    private AsyncTaskService asyncTaskService;

    @Test
    void aaaa() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        Future<String> task1 = asyncTaskService.task1();
        Future<String> task2 = asyncTaskService.task2();

        Future<String> task3 = asyncTaskService.task3();
        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                break;
            }
        }
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("task任务总耗时:" + (currentTimeMillis1 - currentTimeMillis) + "ms");
    }


}
