package com.fsrm.demo.service.impl;

import com.fsrm.common.service.impl.BaseServiceImpl;
import com.fsrm.demo.mapper.DemoMapper;
import com.fsrm.demo.model.DemoEntity;
import com.fsrm.demo.service.IDemoService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class DemoServiceImpl extends BaseServiceImpl<DemoMapper, DemoEntity> implements IDemoService {

}
