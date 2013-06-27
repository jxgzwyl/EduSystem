package com.zikool.edu.auth.service;

import java.util.List;

import com.zikool.edu.auth.entity.Privilege;

public interface IPrivilegeService {

	Privilege findByUri(String requestUrl);

	String queryPrivilegeOpt(String requestUrl);

	List<Privilege> queryByIdUser(Integer userId);

}
