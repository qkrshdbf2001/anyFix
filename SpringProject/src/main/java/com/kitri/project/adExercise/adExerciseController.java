package com.kitri.project.adExercise;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdExerciseController {
	@Resource(name = "adExerciseService")
	AdExerciseService adExerciseService;

	public void setAdExerciseService(AdExerciseService adExerciseService) {
		this.adExerciseService = adExerciseService;
	}

	@RequestMapping(value = "adExercise.do")
	public String adExercise(Model model) {
		ArrayList<AdExercise> list = adExerciseService.getAllExercise();
		model.addAttribute("list", list);// ()�ȿ� �տ� �ִ°Ŵ� �信�� �� �����̸�, �ڿ� �ִ°Ŵ� ���� �� ��ü
		return "adExercise/adExercise.admin";
	}
	
	@RequestMapping(value = "adExerciseWrite.do")
	public String adExerciseWrite() {
		return "adExercise/adExerciseWrite.admin";
	}
	
	@RequestMapping(value = "adExerciseUpdate.do")
	public String adExerciseUpdate(@RequestParam("num") int num, Model model) {
		System.out.println(num);
		AdExercise adExercise = adExerciseService.selectAdExercise(num);
		System.out.println(adExercise);
		model.addAttribute("adExercise", adExercise);
		return "adExercise/adExerciseUpdate.admin";
	}
	
	@RequestMapping(value = "adExerciseSelect.do")
	public String adExerciseSelect() {
		return "adExercise/adExerciseSelect.admin";
	}
	
	@RequestMapping(value = "adExerciseDelete.do")
	public String adExerciseDelete(@RequestParam("num") int num, Model model) {
		System.out.println(num);
		adExerciseService.deleteAdExercise(num);
		return "redirect:adExerciseDetail.do"; // rediret ������ �ٽ� ����
	}
	
	@RequestMapping(value = "adExerciseInsert", method=RequestMethod.POST)
	public String insert(AdExercise ad) {
		adExerciseService.addExercise(ad);
		return "adExercise/adExercise.admin";
	}
	
	@RequestMapping(value = "adExerciseEdit", method=RequestMethod.POST)
	public String edit(AdExercise ad) {
		adExerciseService.editExercise(ad);
		return "adExercise/adExercise.admin";
	}
	
	@RequestMapping(value = "adExerciseDel", method=RequestMethod.POST)
	public String del(int num) {
		adExerciseService.delExercise(num);
		return "adExercise/adExercise.admin";
	}
	
	@RequestMapping(value = "adExerciseGet", method=RequestMethod.POST)
	public String get(int num) {
		adExerciseService.getExercise(num);
		return "adExercise/adExercise.admin";
	}
	
	@RequestMapping(value = "adExerciseDetail.do", method=RequestMethod.GET)
	public String getAll(Model model) { // Model ��Ʈ�ѷ����� ��� ���� ������ ����Ѵ�.
		ArrayList<AdExercise> list = adExerciseService.getAllExercise();
		model.addAttribute("list", list);// ()�ȿ� �տ� �ִ°Ŵ� �信�� �� �����̸�, �ڿ� �ִ°Ŵ� ���� �� ��ü
		return "adExercise/adExerciseDetail.admin";
	}
	
}
