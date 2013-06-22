package com.zikool.edu.common.service;

import com.zikool.edu.common.privilege.SystemPrivilege;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-6-17
 * Time: 下午9:53
 * To change this template use File | Settings | File Templates.
 */
public interface PrivilegeService {
     void batchSave(List<SystemPrivilege> systemPrivilegeList);
     SystemPrivilege  findById(String id);
     int  save(SystemPrivilege systemPrivilege);
     int  delete(SystemPrivilege systemPrivilege);
     int  update(SystemPrivilege systemPrivilege) ;
}
