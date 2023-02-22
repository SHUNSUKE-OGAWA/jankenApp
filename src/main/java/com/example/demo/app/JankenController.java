package com.example.demo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.logic.Divination;
import com.example.demo.logic.Judge;
import com.example.demo.logic.Opponent;
import com.example.demo.logic.Player;

@Controller
@RequestMapping("/janken")
	
public class JankenController {
	
	private final Player player;
	private final Opponent opponent;
	private final Judge judge;
	private final Divination divination;
	
	@Autowired
	public JankenController(Player player, Opponent opponent, Judge judge, Divination divination) {
		this.player = player;
		this.opponent = opponent;
		this.judge = judge;
		this.divination = divination;
	}
	
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("title", "じゃんけん占い");
		return "index";
	}
	
	@GetMapping("/form")
	public String form(JankenForm jankenForm, Model model) {
		model.addAttribute("title", "じゃんけん占い");
		
		return "form";
	}
	
	@PostMapping("/result")
	public String result(@Validated JankenForm jankenForm, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("title", "じゃんけん占い");
			return "form";
		}
		
		//フォームに入力された情報から自分の手を決定
		String myHand = player.selectHand(jankenForm.getSelectedHand());
		
		//あいての手をランダムに決定
		int opponentHandNumber = opponent.decideHand();
		String opponentHand = opponent.selectHand(opponentHandNumber);
		
		//勝敗判定
		String judgeString = judge.judge(jankenForm.getSelectedHand(), opponentHandNumber);
		
		//勝敗判定を数字に変える
		int judgeNum = divination.decideDivinationNum(judgeString);
		
		model.addAttribute("myHandNum", jankenForm.getSelectedHand());
		model.addAttribute("opponentHandNum", opponentHandNumber);
		model.addAttribute("myHand", "あなたの手：" + myHand);
		model.addAttribute("opponentHand", "あいての手：" + opponentHand);
		model.addAttribute("judge", judgeString);
		model.addAttribute("judgeNum", judgeNum);
		model.addAttribute("date", divination.date());
		model.addAttribute("title", "じゃんけん占いの結果");
		
		return "result";
	}
	
	@PostMapping("/start")
	public String start() {
		return "redirect:/janken/";
	}
	

}
