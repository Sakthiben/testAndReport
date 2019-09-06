package com.karya.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.dao.DataAccessException;

import com.karya.model.Login001MB;
import com.karya.model.Menu001MB;


public interface ILoginDAO {
    public Login001MB getLoginResult(String username,String password) throws DataAccessException;
    public Login001MB getLoginResult(String username) throws NoResultException,DataAccessException;
    public List<Menu001MB> getMenuLink(String domain) throws NoResultException,DataAccessException;
}
