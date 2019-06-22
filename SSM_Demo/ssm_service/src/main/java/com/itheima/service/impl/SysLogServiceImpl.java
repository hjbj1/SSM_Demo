package com.itheima.service.impl;

import com.itheima.dao.SysLogDao;
import com.itheima.domain.SysLog;
import com.itheima.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) {
        try {
            sysLogDao.save(sysLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SysLog> findAll() {
        try {
            return sysLogDao.findAll() ;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
