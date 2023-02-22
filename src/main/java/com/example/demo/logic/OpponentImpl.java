package com.example.demo.logic;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class OpponentImpl implements Opponent{
	
	@Override
	public int decideHand() {
		Random rand = new Random();
	    int num = rand.nextInt(3);
	    return num;
	}
	
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
