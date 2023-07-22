package com.pick.you.match;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService{

	@Autowired
	private MatchDao dao;

	@Override
	public void Match_Insert(MatchVO vo) {
		dao.Match_Insert(vo);
	}

	@Override
	public MatchVO Match_GetOne(MatchVO vo) {
		// TODO Auto-generated method stub
		return dao.Match_GetOne(vo);
	}

	@Override
	public List<MatchVO> match_List(MatchVO vo) {
		// TODO Auto-generated method stub
		return dao.match_List(vo);
	}


}
