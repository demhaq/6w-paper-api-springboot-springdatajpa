package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Paper;

public interface PaperRepository extends JpaRepository<Paper, Integer>{

}
