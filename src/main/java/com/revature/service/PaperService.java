package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Paper;
import com.revature.repository.PaperRepository;


@Service
public class PaperService {
	@Autowired
	PaperRepository pr;
	
	public void savePaper(Paper paper) {
		pr.save(paper);
	}
	
	public List<Paper> findAll(){
		return pr.findAll();
	}
}
