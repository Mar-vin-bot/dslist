package com.devsuperior.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameListDto;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repository.GameListRepository;
import com.devsuperior.dslist.repository.GameRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class GameListService {

	@Autowired
	private GameListRepository repo;

	@Autowired
	private GameRepository gameRepo;

	@Transactional(readOnly = true)
	public List<GameListDto> findAll() {
		List<GameList> result = repo.findAll();
		return result.stream().map(element -> new GameListDto(element)).toList();
	}
	
	//Solução do Nelio
	 @Transactional(readOnly = true)
	  public void move(Long listId, int origemPosition, int destinoPosition) {
	  
	  // busca lista por id
	  List<GameMinProjection> list = gameRepo.searchByList(listId);
	  // remove obj da lista oldPosition
	  GameMinProjection obj = list.remove(origemPosition);
	  // inseri obj em newPosition
	  list.add(destinoPosition, obj);
	  
	  //repo.updateBelongingPosition(listId, list.get(i).getId(), i);
	  
	  // Atualiza as posições dos jogos
	  int min = Math.min(origemPosition, destinoPosition);
	  int max = Math.max(origemPosition, destinoPosition);
	 
	  
	  for (int i = min; i <= max; i++) {
	  repo.updateBelongingPosition(listId, list.get(i).getId(), i);
	  }
	  }
	 
/*
	@Transactional(readOnly = true)
	public void move(Long listId, int origemPosition, int destinoPosition) {
		List<GameMinProjection> list = gameRepo.searchByList(listId);
		GameMinProjection obj = list.remove(origemPosition);
		list.add(destinoPosition, obj);

		//repo.updateBelongingPosition(listId, obj.getId(), destinoPosition);

		//loop need for update position for not repeat position
		for (int i = 0; i <= list.size()-1; i++) {
			repo.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
*/

}

/*
 * SELECT TB_BELONGING.* , TB_GAME.TITLE FROM TB_BELONGING
 * INNER JOIN TB_GAME ON TB_GAME.ID = TB_BELONGING.GAME_ID
 * WHERE LIST_ID = 2
 * ORDER BY POSITION;
 */
