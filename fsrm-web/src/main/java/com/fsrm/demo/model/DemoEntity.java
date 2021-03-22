package com.fsrm.demo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fsrm.common.model.BaseEntity;
import lombok.Data;

@Data
@TableName("demo")
public class DemoEntity extends BaseEntity {

    private static final long serialVersionUID = 6025979085029734951L;

    private int id;
    private String name;
    private int age;

}
