package com.dao;

import com.entity.ZhaopinChatEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhaopinChatView;

/**
 * 用户咨询 Dao 接口
 *
 * @author 
 */
public interface ZhaopinChatDao extends BaseMapper<ZhaopinChatEntity> {

   List<ZhaopinChatView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
