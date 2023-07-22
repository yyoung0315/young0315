package com.pick.you.match;

import lombok.Data;

@Data
public class MatchVO {
    private int idx; 
    private String tuser_id; //Primary key,
    private String tuser_gender; 
    private String tuser_learnday;
    private String tuser_time;
    private String tuser_addr; 
    
    
    private String luser_id;
    private String luser_gender;
    private String luser_learnday;
    private String luser_time;
    private String luser_addr;
    
    
    private String match_day;
    

}