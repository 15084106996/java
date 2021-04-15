package org.neuedu.java20his.systeminfo.mapper;

import org.apache.ibatis.annotations.Param;
import org.neuedu.java20his.systeminfo.model.Scheduling;

import java.util.List;

public interface SchedulingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Scheduling record);

    int insertSelective(Scheduling record);

    Scheduling selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Scheduling record);

    int updateByPrimaryKey(Scheduling record);

    List<Scheduling> getScheInfos(@Param("startDate") String startDate,@Param("endingDate") String endingDate);
}