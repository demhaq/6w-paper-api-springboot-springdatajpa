package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Paper;
import com.revature.service.PaperService;


// RestController = Controller + ResponseBody
@Controller
@ResponseBody
public class PaperController {
	@Autowired
	private PaperService ps;
	
	@GetMapping("/")
	public String hello() {
		return "hello";
	}
	@GetMapping("/paper")
	public List<Paper> getAllPapers() {
		return ps.findAll();
	}
	
//	@RequestMapping(path="/paper", method=RequestMethod.POST)
	@PostMapping("/paper")
	public Paper postPaper(@RequestBody Paper paper) {
		ps.savePaper(paper);
		return paper;
	}
	
}
