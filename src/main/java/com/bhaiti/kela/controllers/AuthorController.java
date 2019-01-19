package com.bhaiti.kela.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bhaiti.kela.beans.Articles;
import com.bhaiti.kela.beans.Author;
import com.bhaiti.kela.beans.ParseAuthors;

@Controller
public class AuthorController {
	@RequestMapping(method = RequestMethod.GET, value="/author/allauthors")

	@ResponseBody
	public List<Author> getAuthors() {
		ParseAuthors pa = new ParseAuthors();
		return pa.getAuthors();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/author/get")

	@ResponseBody
	public List<Articles> getAuthorData(@RequestParam(name= "name") String name) {
		ParseAuthors pa = new ParseAuthors();
		name = name.replace("%20", " ").replace("\"", "");
		return pa.getData(name);
	}
}

