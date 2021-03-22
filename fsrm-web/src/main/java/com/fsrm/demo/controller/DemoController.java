package com.fsrm.demo.controller;

import com.fsrm.common.model.Result;
import com.fsrm.demo.model.DemoEntity;
import com.fsrm.demo.service.IDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@Slf4j
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    IDemoService demoService;

    @GetMapping("/demoAll")
    public Result findContractAll() {
        log.info("查询demo:" + LocalDateTime.now());
        List<DemoEntity> allData = demoService.list();
        return Result.succeed(allData);
    }

}
