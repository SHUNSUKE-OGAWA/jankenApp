package com.example.demo.logic;

import org.springframework.stereotype.Service;

@Service
public class JudgeImpl implements Judge{
	
	//勝敗判定プログラム
	//aを自分の手、bを相手の手とし
	//グー = 0, チョキ = 1, パー = 2とする
	@Override
	public String judge(int a, int b) {
		int c = (a - b + 3) % 3;
		if (c == 0) {
			return "あいこ！";
		} else if (c == 2) {
			return "あなたの勝ち！";
		} else {
			return "あなたの負け！";
		}

	}

}
