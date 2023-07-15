package com.devsuperior.dslist.entities;



public class GameListDto {


	private Long id;
	private String name;
	
	public GameListDto() {}

	public GameListDto(GameList obj) {
		id = obj.getId();
		name = obj.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	

	
	
}
