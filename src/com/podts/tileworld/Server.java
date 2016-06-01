package com.podts.tileworld;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
	
	private final Map<UUID,OfflinePlayer> realPlayers = new ConcurrentHashMap<UUID,OfflinePlayer>();
	private final Map<String,OfflinePlayer> realPlayersByName = new ConcurrentHashMap<String,OfflinePlayer>();
	public final Map<UUID,OfflinePlayer> offlinePlayers;
	public final Map<String,OfflinePlayer> playersByName;
	
	public OfflinePlayer getPlayer(UUID id) {
		return realPlayers.get(id);
	}
	
	public OfflinePlayer getPlayer(String name) {
		return realPlayersByName.get(name);
	}
	
	public OfflinePlayer rename(OfflinePlayer p, String newName) {
		synchronized(p) {
			realPlayersByName.remove(p.name);
			realPlayersByName.put(newName, p);
			p.name = newName;
		}
		return p;
	}
	
	public Server() {
		offlinePlayers = Collections.unmodifiableMap(realPlayers);
		playersByName = Collections.unmodifiableMap(realPlayersByName);
	}
	
	
}
