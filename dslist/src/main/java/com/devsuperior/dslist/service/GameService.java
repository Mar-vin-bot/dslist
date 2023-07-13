package com.devsuperior.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repository.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository repo;
	
	public List<GameMinDto> findAll(){
		List<Game> result = repo.findAll();
		 return result.stream().map(gameElement -> new GameMinDto(gameElement)).toList();
	}
	

}
