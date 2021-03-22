package com.fsrm.common.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页实体类
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 7003669741098019525L;

    /**
     * 总数
     */
    private Long count;
    /**
     * 是否成功：0 成功、1 失败
     */
    private Integer code;
    /**
     * 当前页结果集
     */
    private List<T> datas;
    /**
     * 返回消息
     */
    private String message;

    public static <T> PageResult<T> succeed(String msg) {
        return of(null, CodeEnum.SUCCESS.getCode(), null, msg);
    }

    public static <T> PageResult<T> succeed(List<T> model, String msg) {
        return of(null, CodeEnum.SUCCESS.getCode(), model, msg);
    }

    public static <T> PageResult<T> succeed(List<T> model) {
        return of(null, CodeEnum.SUCCESS.getCode(), model, "");
    }

    public static <T> PageResult<T> succeed(Page<T> page, List<T> model) {
        return of(page.getTotal(), CodeEnum.SUCCESS.getCode(), model, "");
    }

    public static <T> PageResult<T> of(Long count, Integer code, List<T> datas, String msg) {
        return new PageResult<>(count, code, datas, msg);
    }

    public static <T> PageResult<T> failed(String msg) {
        return of(null, CodeEnum.ERROR.getCode(),null, msg);
    }

    public static <T> PageResult<T> failed(List<T> model, String msg) {
        return of(null, CodeEnum.ERROR.getCode(), model, msg);
    }

    public static <T> PageResult<T> failed(List<T> model) {
        return of(null, CodeEnum.ERROR.getCode(), model, "");
    }

    public static <T> PageResult<T> failed(Page<T> page, List<T> model) {
        return of(page.getTotal(), CodeEnum.ERROR.getCode(), model, "");
    }
}
