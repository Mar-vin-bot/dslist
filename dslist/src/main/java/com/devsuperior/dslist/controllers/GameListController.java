package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.GameListDto;
import com.devsuperior.dslist.service.GameListService;
import com.devsuperior.dslist.service.GameService;

@RestController
@RequestMapping(value ="/lists")
public class GameListController {
	
	@Autowired
	private GameListService service;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDto> findAll(){
		return  service.findAll();

	}
	
	@GetMapping(value = "/{listId}")
	public List<GameMinDto> findByList(@PathVariable Long listId){
		List<GameMinDto> result = gameService.findByList(listId);
		return result;
	}


}
