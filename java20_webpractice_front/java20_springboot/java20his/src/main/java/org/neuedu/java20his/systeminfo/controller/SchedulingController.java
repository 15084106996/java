package org.neuedu.java20his.systeminfo.controller;

import com.github.pagehelper.PageInfo;
import org.neuedu.java20his.systeminfo.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sche")
public class SchedulingController {
    @Autowired
    SchedulingService schedulingService;
    @GetMapping("/")
    public PageInfo getScheInfos(String startDate, String endingDate,int pageNum,int pageSize) {
        return schedulingService.getScheInfos(startDate,endingDate,pageNum,pageSize);
    }
}
