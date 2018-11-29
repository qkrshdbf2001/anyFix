package com.kitri.project.qa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Qa {
	@RequestMapping(value = "qa.do")
	public String qa() {
		return "qa/qa.tiles";
	}
	
	@RequestMapping(value = "qaWrite.do")
	public String qaWrite() {
		
		return "qa/wirte-qa.tiles";
	}
	
	@RequestMapping(value = "qaUpdate.do")
	public String qaUpdate() {
		
		return "qa/update-qa.tiles";
	}
}
