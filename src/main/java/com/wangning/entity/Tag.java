package com.wangning.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangning
 * @since 2022-04-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("tb_tag")
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * //标签id
     */
    @TableId(value = "tag_id", type = IdType.AUTO)
    private Integer tagId;

    /**
     * //标签名称
     */
    private String tagName;

    /**
     * //创建时间
     */
    private LocalDateTime createTime;

    /**
     * //更新时间
     */
    private LocalDateTime updateTime;


}
