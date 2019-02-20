package com.ihandy.adcaffe.testDemo.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.Future;

@Service
public class AsyncService {

    @Async
    public void doNoReturn(){
        try {
            // 这个方法执行需要三秒
            Thread.sleep(3000);
            System.out.println("方法执行结束" + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async("taskExecutor")
    public Future<String> doReturn(int i){
        try {
            // 这个方法需要调用500毫秒
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 消息汇总
        return new AsyncResult<>(String.format("这个是第{%s}个异步调用的证书", i));
    }

    @Async // 通过@Async注解表明该方法是一个异步方法，如果注解在类级别，表明该类下所有方法都是异步方法，而这里的方法自动被注入使用ThreadPoolTaskExecutor 作为 TaskExecutor
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务：" + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1：" + (i+1));
    }
}
