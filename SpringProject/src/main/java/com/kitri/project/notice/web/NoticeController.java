package com.kitri.project.notice.web;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kitri.project.notice.service.NoticeService;

@Controller
public class NoticeController {
	
	@Resource(name = "noticeService")
	private NoticeService noticeService;
	
	@RequestMapping(value = "notice.do")
	public String notice(Model model) {
		ArrayList<Notice> n = noticeService.selectNoticeList();
		model.addAttribute("list", n);
		return "notice/notice.tiles";
	}
	
	@RequestMapping(value = "noticeDetail.do")
	public String noticeDetail(@RequestParam("num")int num,Model model) {
		Notice n = noticeService.selectNotice(num);
		model.addAttribute("list", n);
		return "notice/notice-detail.tiles";
	}
	
	@RequestMapping(value = "notice-write.do",method = RequestMethod.GET)
	public String noticeWrite() {
		return "notice/notice-write.tiles";
	}
	
	@RequestMapping(value = "notice-write.do",method = RequestMethod.POST)
	public String noticeWritePost(Notice n) {
		noticeService.insertNotice(n);
		return "redirect:notice.do";
	}
	
	@RequestMapping(value = "notice-update.do")
	public String noticeUpdate() {
		return "notice/notice-update.tiles";
	}
}
