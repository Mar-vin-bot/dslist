package com.devsuperior.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameDto;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repository.GameRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {
	
	@Autowired
	private GameRepository repo;
	
	@Transactional(readOnly = true)
	public List<GameMinDto> findAll(){
		List<Game> result = repo.findAll();
		 return result.stream().map(gameElement -> new GameMinDto(gameElement)).toList();
	}
	

	@Transactional(readOnly = true)
	public GameDto findById(Long id){
		Game obj = repo.findById(id).get();
		return new GameDto(obj);
	}
	
	//Sendo criada aqui pq retorna games	
	@Transactional(readOnly = true)
	public List<GameMinDto> findByList(Long listId){
		List<GameMinProjection> result = repo.searchByList(listId);
		 return result.stream().map(element -> new GameMinDto(element)).toList();
	}

	
	

}
