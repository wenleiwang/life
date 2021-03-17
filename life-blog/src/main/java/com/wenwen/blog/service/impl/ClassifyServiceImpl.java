package com.wenwen.blog.service.impl;

import com.wenwen.blog.entity.Article;
import com.wenwen.blog.entity.Classify;
import com.wenwen.blog.mapper.ClassifyMapper;
import com.wenwen.blog.service.IClassifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wenwen.blog.util.response.ResponseBase;
import com.wenwen.blog.util.response.ResponseListBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WenleiWang
 * @since 2020-11-06
 */
@Primary
@Service
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify> implements IClassifyService {
    @Autowired
    ClassifyMapper classifyMapper;

    @Override
    public ResponseBase updateClassify(Integer classifyId, Integer userId, String classifyName) {
        ResponseBase response = new ResponseBase();
        Classify classify = new Classify();
        Date date = new Date();
        if(classifyId == null){
            //插入
            classify.setClassifyName(classifyName);
            classify.setAddTime(date);
            classify.setUpdateTime(date);
            classify.setUserId(userId);
            classify.setDeleted(false);
            final int insert = classifyMapper.insert(classify);
            if(insert <= 0){
                response.fail("插入分类失败，操作数据库失败！");
            }else{
                response.successful("插入分类成功！");
            }
        }else{
            //修改
            classify.setClassifyId(classifyId);
            classify.setClassifyName(classifyName);
            classify.setUpdateTime(date);
            classify.setDeleted(false);
            final int update = classifyMapper.updateById(classify);
            if(update <= 0){
                response.fail("更新分类失败，操作数据库失败！");
            }else{
                response.successful("更新分类成功！");
            }
        }

        return response;
    }

    @Override
    public ResponseBase deleteClassify(Integer classifyId) {
        ResponseBase response = new ResponseBase();
        if (classifyId == null || classifyId <= 0){
            response.fail("分类非法");
            return response;
        }
        final int delete = classifyMapper.deleteById(classifyId);
        if(delete > 0){
            response.successful("删除分类成功！");
        }else{
            response.fail("删除分类失败，操作数据库失败！");
        }
        return response;
    }

    @Override
    public ResponseListBase<Classify> listClassify(Integer userId) {
        ResponseListBase<Classify> response = new ResponseListBase<>();
        if (userId == null || userId <= 0){
            response.fail("用户非法");
            return response;
        }
        List<Classify> list = classifyMapper.listClassifyByUserId(userId);
        if(list == null){
            response.fail("查询出错！");
            return response;
        }
        if(list.size() == 0){
            response.successful("查询成功，没有符合条件的数据！");
            return response;
        }
        response.setData(list);
        response.successful("查询成功！");
        return response;
    }

    @Override
    public ResponseListBase<Article> listArticleFromClassifyId(Integer classifyId, Integer userId) {
        ResponseListBase<Article> response = new ResponseListBase<>();

        List<Article> articles = classifyMapper.listArticleFromClassifyId(classifyId, userId);
        response.setData(articles);
        response.successful("查询成功！");
        return response;
    }
}
