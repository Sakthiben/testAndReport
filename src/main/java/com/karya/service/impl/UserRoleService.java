package com.karya.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IUserRoleDAO;
import com.karya.model.Login001MB;
import com.karya.model.Role001MB;
import com.karya.model.UserRole001MB;
import com.karya.service.IUserRoleService;


@Service("RoleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserRoleService implements IUserRoleService   {
	
	@Autowired
	private IUserRoleDAO roleDAO;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void userRoleAddAction(UserRole001MB userrole001mb) {
		roleDAO.userRoleAddAction(userrole001mb);
	}
	
	public UserRole001MB userRoleEditAction(int id) {
		return roleDAO.userRoleEditAction(id);
	}
	
	public void userRoleDeleteAction(int id) {
		roleDAO.userRoleDeleteAction(id);
	}
	
	public List<UserRole001MB> listallusers() {
		return roleDAO.listallusers();
	}
	
	public List<Role001MB> getRoleList() {
		return roleDAO.getRoleList();
	}
	
	public List<Login001MB> getUserList() {
		return roleDAO.getUserList();
	}
	
}