package com.fsrm.common.mapper;

/**
 * mapper 父类，注意这个类不要让 mp 扫描到！！
 */
public interface BaseMapper<T> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T> {
    // 这里可以放一些公共的方法
}
