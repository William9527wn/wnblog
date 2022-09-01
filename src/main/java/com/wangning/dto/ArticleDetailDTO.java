package com.wangning.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ArticleDetailDTO {

    /**
     * id
     */
    private Integer articleId;

    /**
     * 文章缩略图
     */
    private String articleCover;

    /**
     * 标题
     */
    private String articleTitle;

    /**
     * 内容
     */
    private String articleContent;

    /**
     * 发表时间
     */
    private Date createTime;

    /**
     * 是否置顶
     */
    private Boolean isTop;

    /**
     * 文章分类id
     */
    private Integer categoryId;

    /**
     * 文章分类名
     */
    private String categoryName;

    /**
     * 文章标签
     */
    private List<TagDTO> tagDTOList;

    /**
     * 文章浏览量
     */
    private Long viewCount;

    /**
     * 文章点赞量
     */
    private Long LikeCount;
}
