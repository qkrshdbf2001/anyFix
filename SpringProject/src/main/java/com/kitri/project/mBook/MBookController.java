package com.kitri.project.mBook;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;


import com.kitri.project.member.Member;
import com.kitri.project.member.MemberService;

@Controller
public class MBookController {
	@Resource(name="memberService")
	private MemberService memberService;
	public void setService(MemberService memberService) { this.memberService = memberService; }
	
	
	/*������ ���� ����*/
	@RequestMapping(value = "mInsert.do")
	public ModelAndView mInsert(@RequestParam("id")String id) {
		ModelAndView mav = new ModelAndView("mBook/memberInsert.admin");
		Member m = memberService.getMyInfo(id);
		mav.addObject("m",m);
		return mav;
	}
	
	/*������ ����Ʈ ����*/
	@RequestMapping(value="bookMember.do")
	public ModelAndView bookMemberList() {	// ���Խ��� ����� ���
		ArrayList<Member> list = memberService.getReservation();
		ModelAndView mav = new ModelAndView("mBook/bookMember.admin");
		mav.addObject("list", list);
		return mav;
	}
	
	/*������ ���� ����*/
	@RequestMapping(value="bookMember.do", method=RequestMethod.POST)
	public String memberConfirm(Member m) {		
		memberService.adminConfirm(m.getId());
		return "redirect:bookMember.do";
	}
	
	/*�����ڰ� ȸ������ ����*/
	@RequestMapping(value="adminMemberUpdate", method=RequestMethod.POST)
	public String adminMemberUpdate(Member m) {
		memberService.edit(m);
		return "redirect:bookMember.do";
	}
	
	/*ȸ�� ��ü����*/
	@RequestMapping(value="memberList.do")
	public ModelAndView memberList() {
		ModelAndView mav = new ModelAndView("member/memberList.admin");
		ArrayList<Member> list = memberService.getAll();
		mav.addObject("list",list);
		return mav;
	}
	
	/*admin_confirm �÷��� 'o' select ȸ�� ��ü��Ͽ��� ȸ�� �󼼺��� ������ ���� ��ư ������ �Ⱥ����� ����*/
	@RequestMapping(value="memberReservationCheck", method=RequestMethod.POST)
	public String memberReservationCheck(@RequestParam(value="id")String id, Model x) {
		Member m = memberService.getReservationComplete(id);
		System.out.println(m);
		boolean flag = false;	// �˻���� ����
		if(m==null) {
			flag = true;	// �˻���� ����
		}
		x.addAttribute("flag", flag);
		return "ajax/reservationCheck";
	}
}

























