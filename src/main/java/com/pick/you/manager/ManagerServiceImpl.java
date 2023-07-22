package com.pick.you.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private ManagerDao dao;

	@Override
	public ManagerVO Manager_Login(ManagerVO vo) {
		return dao.Manager_Login(vo);
		
	}


}
