package com.example.demo.app;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class JankenForm {
	//0 = グー, 1 = チョキ, 2 = パー
	@Min(value = 0, message = "")
	@Max(value = 2, message = "")
	private int selectedHand;
	
	public JankenForm() {}

	public int getSelectedHand() {
		return selectedHand;
	}

	public void setSelectedHand(int selectedHand) {
		this.selectedHand = selectedHand;
	}

}
