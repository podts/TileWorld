package com.podts.tileworld;

import java.util.UUID;

public class OfflinePlayer {
	
	public final UUID id;
	protected String name;
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof OfflinePlayer)
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
	
	public OfflinePlayer(String name) {
		id = UUID.randomUUID();
		this.name = name;
	}
	
	public OfflinePlayer(UUID id, String name) {
		this.id = id;
		this.name = name;
	}
	
}
