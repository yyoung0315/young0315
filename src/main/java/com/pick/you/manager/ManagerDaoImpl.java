package com.pick.you.manager;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ManagerDaoImpl implements ManagerDao{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public ManagerVO Manager_Login(ManagerVO vo) {
		
		return mybatis.selectOne("ManagerDao.MANAGER_LOGIN",vo);
	}
}
