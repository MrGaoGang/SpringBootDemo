package com.mrgao.mapper;

import com.mrgao.enty.User;

import java.util.List;

public interface UserTMapper {
	
	public User selectUserByID(int id);
	
	public List<User> selectUsersByName(String userName);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(int id);
	
}

