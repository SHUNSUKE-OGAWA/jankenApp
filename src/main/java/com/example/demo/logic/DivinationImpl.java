package com.example.demo.logic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class DivinationImpl implements Divination {
	
	public DivinationImpl() {}
	
	@Override
	public String date() {
		LocalDateTime now = LocalDateTime.now(); 
		DateTimeFormatter form = DateTimeFormatter.ofPattern("MM月dd日" ); 
		String formDT = now.format(form);
		
		return formDT;
	}
	
	
	@Override
	public int decideDivinationNum(String judge) {
		//JudgeImplによって返される勝敗判定を数字化する
		//0=あいこ, 1=勝ち, 2=負けとする 
		
		if(judge.equals("あいこ！")) {
			return 0;
		}
		if(judge.equals("あなたの勝ち！")) {
			return 1;
		}
		if(judge.equals("あなたの負け！")) {
			return 2;
		}
		return 3;
	}
	
}