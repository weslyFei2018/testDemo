package com.ihandy.adcaffe.testDemo;

import com.ihandy.adcaffe.testDemo.async.service.AsyncService;
import com.ihandy.adcaffe.testDemo.jms.producer.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@EnableAsync
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemoApplicationTest {

    @Autowired
    private Producer producer;
    @Autowired
    private AsyncService asyncService;

    @Test
    public void contextLoads() throws InterruptedException {
        Destination destination = new ActiveMQQueue("mytest.queue");

        for(int i=0; i<10; i++){
            producer.sendMessage(destination, "myname is weichangjin!!!");
        }
    }

    @Test
    public void asyn() throws InterruptedException {
        long start = System.currentTimeMillis();
        asyncService.doNoReturn();
        System.out.println(String.format("任务执行成功,耗时{%s}", System.currentTimeMillis() - start));
        Thread.sleep(3300);
    }

    @Test
    public void testAsyncReturn() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            Future<String> future = asyncService.doReturn(i);
            futures.add(future);
        }
        List<String> response = new ArrayList<>();
        for (Future future : futures) {
            String string = (String) future.get();
            response.add(string);
        }
        System.out.println(("data:"+response));
        System.out.println(("消耗时间:"+String.format("任务执行成功,耗时{%s}毫秒", System.currentTimeMillis() - start)));
    }
}
