package com.tina.common.db.dao;

import com.tina.common.db.entity.DmCount;
import com.tina.common.db.entity.DmCountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmCountMapper {
    long countByExample(DmCountExample example);

    int deleteByExample(DmCountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmCount record);

    int insertSelective(DmCount record);

    List<DmCount> selectByExample(DmCountExample example);

    DmCount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DmCount record, @Param("example") DmCountExample example);

    int updateByExample(@Param("record") DmCount record, @Param("example") DmCountExample example);

    int updateByPrimaryKeySelective(DmCount record);

    int updateByPrimaryKey(DmCount record);
}