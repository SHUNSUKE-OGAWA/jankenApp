package com.example.demo.logic;

import org.springframework.stereotype.Service;

@Service
public class PlayerImpl implements Player{
	
	public PlayerImpl() {}
	
	@Override
	public String selectHand(int num) {
		if(num == 0) {
			return "グー";
		}
		if(num == 1) {
			return "チョキ";
		}
		if(num == 2) {
			return "パー";
		}
		return "想定外でーす";
	} 

}
