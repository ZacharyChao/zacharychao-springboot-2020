package com.zacharychao.myspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zacharychao.myspringboot.exception.MyException;

@Controller
public class MyController {
	@RequestMapping("/out")
	@ResponseBody
	public String out() {
		return "success";
	}
	
	@RequestMapping("testException")
    public String testException() throws Exception{
        throw new MissingServletRequestParameterException("name","String");
    }

    @RequestMapping("testMyException")
    public String testMyException() throws MyException{
        throw new MyException("i am a myException");
    }
}
