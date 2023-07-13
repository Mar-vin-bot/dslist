package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.service.GameService;

@RestController
@RequestMapping(value ="/games")
public class GameControllador {
	
	@Autowired
	private GameService service;
	
	@GetMapping
	public List<GameMinDto> findAll(){
		List<GameMinDto> result = service.findAll();
		return result;
	}

	@GetMapping(value = '/{id}')
	public GameDto findById(@PathVariable Long id){
		GameDto result = service.findById(id);
		return result;
	}



}
