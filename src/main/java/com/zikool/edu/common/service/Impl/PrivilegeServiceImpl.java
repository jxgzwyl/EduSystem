package com.zikool.edu.common.service.Impl;

import com.zikool.edu.common.privilege.SystemPrivilege;
import com.zikool.edu.common.service.PrivilegeService;
import com.zikool.edu.db.JDBCDaoBase;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-6-17
 * Time: 下午11:10
 * To change this template use File | Settings | File Templates.
 */
@Service("privilegeService")
public class PrivilegeServiceImpl extends JDBCDaoBase<SystemPrivilege> implements PrivilegeService {

    @Override
    public void batchSave(List<SystemPrivilege> systemPrivilegeList) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public SystemPrivilege findById(String id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int save(SystemPrivilege systemPrivilege) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int delete(SystemPrivilege systemPrivilege) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int update(SystemPrivilege systemPrivilege) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
