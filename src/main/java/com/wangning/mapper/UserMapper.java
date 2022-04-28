package com.wangning.mapper;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wangning.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangning
 * @since 2022-04-28
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}