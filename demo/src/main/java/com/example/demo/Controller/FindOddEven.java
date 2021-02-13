package com.example.demo.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindOddEven {
	
	
	@PostMapping("/findOddEven")
	public Number findOddOrEven(@RequestBody Number num) {
		Number nums = new Number();
		if(num.number % 2 == 0) {
			nums.number = num.number;
			nums.type = "Even";
		}else {
			nums.number = num.number;
			nums.type = "odd";
		}
		return nums;
	}

	
}
