package com.pick.you.usertkd;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UsertkdDaoImpl implements UsertkdDao{
	
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public void Lusertkd_Insert(LusertkdVO vo) {
		mybatis.insert("UsertkdDao.LUSERTKD_INSERT", vo);
		
	}

	@Override
	public void Tusertkd_Insert(TusertkdVO vo) {
		mybatis.insert("UsertkdDao.TUSERTKD_INSERT", vo);
		
	}

	@Override
	public List<LusertkdVO> Lusertkd_Login(LusertkdVO vo) {
		
		return mybatis.selectList("UsertkdDao.LUSERTKD_LOGIN", vo);
	}

	@Override
	public List<TusertkdVO> Tusertkd_Login(TusertkdVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("UsertkdDao.TUSERTKD_LOGIN", vo);
	}

	@Override
	public List<LusertkdVO> Lusertkd_List(LusertkdVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("UsertkdDao.LUSERTKD_LIST", vo);
	}

	@Override
	public List<TusertkdVO> Tusertkd_List(TusertkdVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("UsertkdDao.TUSERTKD_LIST", vo);
	}

	@Override
	public LusertkdVO Lusertkd_GetOne(LusertkdVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("UsertkdDao.LUSER_GETONE", vo);
	}

	@Override
	public TusertkdVO Tusertkd_GetOne(TusertkdVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("UsertkdDao.TUSER_GETONE", vo);
	}

	@Override
	public LusertkdVO laddr_GetOne(LusertkdVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("UsertkdDao.LADDR_GETONE", vo);
	}

	@Override
	public TusertkdVO taddr_GetOne(TusertkdVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("UsertkdDao.TADDR_GETONE", vo);
	}

	@Override
	public void luserEdit(LusertkdVO vo) {
		mybatis.update("UsertkdDao.LuserEdit", vo);
		
	}

	@Override
	public void tuserEdit(TusertkdVO vo) {
		mybatis.update("UsertkdDao.TuserEdit", vo);
		
	}



}
