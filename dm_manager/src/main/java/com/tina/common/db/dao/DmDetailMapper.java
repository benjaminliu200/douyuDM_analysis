package com.tina.common.db.dao;

import com.tina.common.db.entity.DmDetail;
import com.tina.common.db.entity.DmDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmDetailMapper {
    long countByExample(DmDetailExample example);

    int deleteByExample(DmDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmDetail record);

    int insertSelective(DmDetail record);

    List<DmDetail> selectByExample(DmDetailExample example);

    DmDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DmDetail record, @Param("example") DmDetailExample example);

    int updateByExample(@Param("record") DmDetail record, @Param("example") DmDetailExample example);

    int updateByPrimaryKeySelective(DmDetail record);

    int updateByPrimaryKey(DmDetail record);
}