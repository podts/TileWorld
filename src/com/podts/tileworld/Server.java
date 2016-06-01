package com.podts.tileworld;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
	
	private final Map<UUID,Player> realPlayers = new ConcurrentHashMap<UUID,Player>();
	private final Map<String,Player> realPlayersByName = new ConcurrentHashMap<String,Player>();
	private final Map<UUID,OfflinePlayer> realOfflinePlayers = new ConcurrentHashMap<UUID,OfflinePlayer>();
	private final Map<String,OfflinePlayer> realOfflinePlayersByName = new ConcurrentHashMap<String,OfflinePlayer>();
	
	public final Map<UUID,Player> players;
	public final Map<String,Player> playersByName;
	public final Map<UUID,OfflinePlayer> offlinePlayers;
	public final Map<String,OfflinePlayer> offlinePlayersByName;
	
	public OfflinePlayer getOfflinePlayer(UUID id) {
		return offlinePlayers.get(id);
	}
	
	public OfflinePlayer getOfflinePlayer(String name) {
		return offlinePlayersByName.get(name);
	}
	
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
		offlinePlayers = Collections.unmodifiableMap(realOfflinePlayers);
		offlinePlayersByName = Collections.unmodifiableMap(realOfflinePlayersByName);
	}
	
	
}
