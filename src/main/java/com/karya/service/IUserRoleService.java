package com.karya.service;

import java.util.List;

import com.karya.model.Login001MB;
import com.karya.model.Role001MB;
import com.karya.model.UserRole001MB;

public interface IUserRoleService{
	public void userRoleAddAction(UserRole001MB userrole001mb);
	public UserRole001MB userRoleEditAction(int id);
	public void userRoleDeleteAction(int id);
	public List<UserRole001MB> listallusers();
	public List<Role001MB> getRoleList();
	public List<Login001MB> getUserList();
}

	


