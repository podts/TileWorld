package com.podts.tileworld;

import java.util.UUID;

public class Player extends OfflinePlayer {
	
	public Player(String name) {
		super(name);
	}
	
	public Player(UUID id, String name) {
		super(id, name);
	}
	
}
