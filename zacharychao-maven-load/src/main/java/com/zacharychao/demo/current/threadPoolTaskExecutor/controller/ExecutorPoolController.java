package com.zacharychao.demo.current.threadPoolTaskExecutor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zacharychao.demo.current.threadPoolTaskExecutor.component.AsyncComponent;

@RestController
public class ExecutorPoolController {
	@Autowired
	private AsyncComponent asyncComponent;
	
	@GetMapping("/testExecutorPool")
	public String testExecutorPool() {
		try {
			for(int i = 0 ; i < 20 ; i ++) {
				asyncComponent.doTaskThree();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "testExecutor";
	}
}
