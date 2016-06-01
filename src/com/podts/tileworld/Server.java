package com.podts.tileworld;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
	
	private final Map<UUID,Player> realPlayers = new ConcurrentHashMap<UUID,Player>();
	private final Map<String,Player> realPlayersByName = new ConcurrentHashMap<String,Player>();
	public final Map<UUID,Player> players;
	public final Map<String,Player> playersByName;
	
	public Player getPlayer(UUID id) {
		return realPlayers.get(id);
	}
	
	public Player getPlayer(String name) {
		return realPlayersByName.get(name);
	}
	
	public Player rename(Player p, String newName) {
		synchronized(p) {
			realPlayersByName.remove(p.name);
			realPlayersByName.put(newName, p);
			p.name = newName;
		}
		return p;
	}
	
	public Server() {
		players = Collections.unmodifiableMap(realPlayers);
		playersByName = Collections.unmodifiableMap(realPlayersByName);
	}
	
	
}
