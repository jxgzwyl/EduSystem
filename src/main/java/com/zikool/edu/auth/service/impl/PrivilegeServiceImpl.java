package com.zikool.edu.auth.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zikool.edu.auth.dao.IPrivilegeDAO;
import com.zikool.edu.auth.entity.Privilege;
import com.zikool.edu.auth.service.IPrivilegeService;
import com.zikool.edu.frame.common.GlobalConfigure;

@Service("iPrivilegeService")
public class PrivilegeServiceImpl implements IPrivilegeService {

	@Autowired
	@Qualifier("iPrivilegeDAO")
	private IPrivilegeDAO privilegeDAO;

	public Privilege findByIdPrivilege(Integer privilegeId) {
		Map<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("privilegeId", privilegeId);
		return this.privilegeDAO.queryPrivilegeOne(parameter);
	}
	
	@Override
	public List<Privilege> queryByIdUser(Integer userId) {
		Map<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("userId", userId);
		return this.privilegeDAO.queryPrivilegeList(parameter);
	}
	
	@Override
	public Privilege findByUri(String requestUrl) {
		Map<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("uri", requestUrl);
		return this.privilegeDAO.queryPrivilegeOne(parameter);
	}

	@Override
	public String queryPrivilegeOpt(String requestUrl) {
		String optName = findParentPermission(requestUrl);
		Privilege privilege = this.findByUri(requestUrl);
		if(privilege.isMain()){
			optName += GlobalConfigure.DEFAULT_PERMISSION_VIEW;
		}
		return optName;
	}

	private String findParentPermission(String uri){
		Privilege permission = this.findByUri(uri);
		Integer pid = permission.getPid();
		if(pid == 0){
			return permission.getPrivilegeName();
		}
		Privilege parent = this.findByIdPrivilege(pid);
		
		StringBuilder builder = new StringBuilder();
		builder.append(findParentPermission(parent.getUri())).append(":").append(permission.getPrivilegeName());
		return builder.toString();
	}
	
}
