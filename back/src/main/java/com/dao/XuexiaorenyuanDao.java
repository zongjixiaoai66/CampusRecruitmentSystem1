package com.dao;

import com.entity.XuexiaorenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XuexiaorenyuanView;

/**
 * 学校人员 Dao 接口
 *
 * @author 
 */
public interface XuexiaorenyuanDao extends BaseMapper<XuexiaorenyuanEntity> {

   List<XuexiaorenyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
