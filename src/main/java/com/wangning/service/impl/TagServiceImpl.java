package com.wangning.service.impl;

import com.wangning.entity.Tag;
import com.wangning.mapper.TagMapper;
import com.wangning.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangning
 * @since 2022-04-28
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
