package com.wenwen.blog.service.impl;

import com.wenwen.blog.entity.Classify;
import com.wenwen.blog.mapper.ClassifyMapper;
import com.wenwen.blog.service.IClassifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wenwen.blog.util.response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WenleiWang
 * @since 2020-11-06
 */
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
}
