package com.fsrm.excel;

import com.fsrm.demo.service.IDemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {

    @Autowired
    IDemoService demoService;

    @Test
    public void testDemo() {
        log.info("测试:" + LocalDateTime.now());
    }
}
