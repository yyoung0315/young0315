package com.pick.you.match;

import java.util.List;

public interface MatchDao {
	
	void Match_Insert(MatchVO vo);
	
	MatchVO Match_GetOne(MatchVO vo);
	
	List<MatchVO> match_List(MatchVO vo);
}
