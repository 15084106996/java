package org.neuedu.java20his.systeminfo.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.neuedu.java20his.systeminfo.mapper.SchedulingMapper;
import org.neuedu.java20his.systeminfo.model.Scheduling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SchedulingService {
    @Autowired
    SchedulingMapper schedulingMapper;
    public PageInfo getScheInfos(String startDate, String endingDate, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Scheduling> schedulingList = schedulingMapper.getScheInfos(startDate, endingDate);
        PageInfo pageInfo = new PageInfo(schedulingList);
        return pageInfo;
    }
}
