package com.fsrm.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.ExceptionUtils;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fsrm.common.service.IBaseService;
import com.fsrm.common.exception.IdempotencyException;

import java.io.Serializable;
import java.util.Objects;

/**
 * service实现父类
 *
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements IBaseService<T> {
    @Override
    public boolean saveIdempotency(T entity, Wrapper<T> countWrapper, String msg) throws Exception {
                //判断记录是否已存在
                int count = super.count(countWrapper);
                if (count == 0) {
                    return super.save(entity);
                } else {
                    if (StringUtils.isBlank(msg)) {
                        msg = "已存在";
                    }
                    throw new IdempotencyException(msg);
                }
    }

    @Override
    public boolean saveIdempotency(T entity, Wrapper<T> countWrapper) throws Exception {
        return saveIdempotency(entity, countWrapper, null);
    }

    @Override
    public boolean saveOrUpdateIdempotency(T entity, Wrapper<T> countWrapper, String msg) throws Exception {
        if (null != entity) {
            Class<?> cls = entity.getClass();
            TableInfo tableInfo = TableInfoHelper.getTableInfo(cls);
            if (null != tableInfo && StringUtils.isNotBlank(tableInfo.getKeyProperty())) {
                Object idVal = ReflectionKit.getMethodValue(cls, entity, tableInfo.getKeyProperty());
                if (StringUtils.checkValNull(idVal) || Objects.isNull(getById((Serializable) idVal))) {
                    if (StringUtils.isBlank(msg)) {
                        msg = "已存在";
                    }
                    return this.saveIdempotency(entity, countWrapper, msg);
                } else {
                    return updateById(entity);
                }
            } else {
                throw ExceptionUtils.mpe("Error:  Can not execute. Could not find @TableId.");
            }
        }
        return false;
    }

    @Override
    public boolean saveOrUpdateIdempotency(T entity, Wrapper<T> countWrapper) throws Exception {
        return this.saveOrUpdateIdempotency(entity, countWrapper, null);
    }
}
