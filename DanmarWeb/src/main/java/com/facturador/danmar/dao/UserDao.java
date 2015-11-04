package com.facturador.danmar.dao;

import com.facturador.danmar.model.User;

public interface UserDao {

	User findByUserName(String username);

}