package com.pick.you.match;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MatchDaoImpl implements MatchDao{
	
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public void Match_Insert(MatchVO vo) {
		mybatis.insert("MatchDao.MATCHINSERT",vo);
		
	}

	@Override
	public MatchVO Match_GetOne(MatchVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("MatchDao.MATCH_GETONE", vo);
	}

	@Override
	public List<MatchVO> match_List(MatchVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("MatchDao.MATCH_LIST", vo);
	}



}
