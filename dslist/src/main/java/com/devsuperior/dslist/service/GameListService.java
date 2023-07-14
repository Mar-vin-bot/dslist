package com.devsuperior.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameDto;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.entities.GameListDto;
import com.devsuperior.dslist.repository.GameListRepository;
import com.devsuperior.dslist.repository.GameRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository repo;
	
	@Transactional(readOnly = true)
	public List<GameListDto> findAll(){
		List<GameList> result = repo.findAll();
		 return result.stream().map(element -> new GameListDto(element)).toList();
	}
	



	
	

}
