package com.wangning.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangning.dto.ArticleDetailDTO;
import com.wangning.dto.ArticleHomeDTO;
import com.wangning.entity.Article;
import com.wangning.mapper.ArticleMapper;
import com.wangning.service.IArticleService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.function.Function;

import static com.wangning.contants.RedisPrefixConst.ARTICLE_VIEWS_COUNT;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private HttpSession session;

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 获取当前页数的首页文章
     * @param current：当前页数
     * @return ArticleHomeDTO
     */
    @Override
    public List<ArticleHomeDTO> getAllArticlesHomeList(Long current) {
        List<ArticleHomeDTO> articleHomeDTOList = articleMapper.getAllArticles((current-1)*10);
        return articleHomeDTOList;
    }

    /**
     * 根据ID获取文章详情
     * @param articleId:文章Id
     * @return ArticleDetailDTO
     */
    @Override
    public ArticleDetailDTO getArticleById(Integer articleId) {
        updateViewCount(articleId);

        return null;
    }

    /**
     * 更新文章浏览量
     * @param articleId 文章id
     */
    @Async
    public void updateViewCount(Integer articleId) {
        Set<Integer> articleSet = (Set<Integer>)session.getAttribute("articleSet");
        if (ObjectUtil.isNull(articleSet)) {
            articleSet = new HashSet<>();
        }
        if (!articleSet.contains(articleId)){
            //如果session的articleSet中不包含articleId，说明在该会话周期中，第一次访问
            articleSet.add(articleId);
            session.setAttribute("articleSet", articleSet);
            //该文章浏览量+1
            redisTemplate.boundHashOps(ARTICLE_VIEWS_COUNT).increment(articleId,1);
        }

    }


}
