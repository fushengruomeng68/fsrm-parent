package com.fsrm.common.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * 实体父类
 *
 */
@Setter
@Getter
public class BaseEntity<T extends Model<?>> extends Model<T> {

}
