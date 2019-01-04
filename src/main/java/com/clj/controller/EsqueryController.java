package com.clj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

@RestController
public class EsqueryController {
	/*@Autowired
	private ProjectSearchService projectSearchService;*/
	
	/*@RequestMapping(value = "/project/findProjectName")
	public List<Project> findOneCity(
			@RequestParam(value = "projectName", required = true) String projectName,@RequestParam(value = "pageNo", required = true) int pageNo) {
		PageHelper.startPage(pageNo, Constants.pageSize);
		return projectSearchService.findProjectName(projectName);
	}*/
}
