package com.kitri.project.qa11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Qa11 {
	@RequestMapping(value = "qa11.do")
	public String qa() {
		return "qa11/qa11.tiles";
	}
	
	@RequestMapping(value = "qaDetail11.do")
	public String qaDetail() {
		
		return "qa11/detail-qa11.tiles";
	}
	
	@RequestMapping(value = "qaWrite11.do")
	public String qaWrite() {
		
		return "qa11/wirte-qa11.tiles";
	}
	
	@RequestMapping(value = "qaUpdate11.do")
	public String qaUpdate() {
		
		return "qa11/update-qa11.tiles";
	}
}