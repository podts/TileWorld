package com.podts.tileworld;

import java.util.UUID;

public class Player {
	
	public final UUID id;
	protected String name;
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Player)
			return hashCode() == o.hashCode();
		return false;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public Player(String name) {
		id = UUID.randomUUID();
		this.name = name;
	}
	
	public Player(UUID id, String name) {
		this.id = id;
		this.name = name;
	}
	
}
