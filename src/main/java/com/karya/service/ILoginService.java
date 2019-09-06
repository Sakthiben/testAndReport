package com.karya.service;

import java.util.List;

import com.karya.model.Login001MB;
import com.karya.model.Menu001MB;

public interface ILoginService {
	public Login001MB getLoginResult(String username, String password);
	public List<Menu001MB> getMenuLink(String domain);
}
