package com.fsrm.demo.mapper;

import com.fsrm.common.mapper.BaseMapper;
import com.fsrm.demo.model.DemoEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoMapper extends BaseMapper<DemoEntity> {


}
