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
	
	public boolean addOfflinePlayer(OfflinePlayer p) {
		if(getOfflinePlayer(p.id) != null) return false;
		realOfflinePlayers.put(p.id, p);
		realOfflinePlayersByName.put(p.name, p);
		return true;
	}
	
	public boolean addPlayer(Player p) {
		if(getPlayer(p.id) != null) return false;
		realPlayers.put(p.id, p);
		realPlayersByName.put(p.name, p);
		return true;
	}
	
	public void removeOfflinePlayer(OfflinePlayer p) {
		realOfflinePlayers.remove(p.id);
		realOfflinePlayers.remove(p.name);
	}
	
	public void removePlayer(Player p) {
		realPlayers.remove(p.id);
		realPlayersByName.remove(p.name);
	}
	
	public OfflinePlayer rename(OfflinePlayer p, String newName) {
		synchronized(p) {
			realOfflinePlayersByName.remove(p.name);
			realOfflinePlayersByName.put(newName, p);
			p.name = newName;
		}
		return p;
	}
	
	public static void main(String[] args) {
		
	}
	
	public Server() {
		players = Collections.unmodifiableMap(realPlayers);
		playersByName = Collections.unmodifiableMap(realPlayersByName);
		offlinePlayers = Collections.unmodifiableMap(realOfflinePlayers);
		offlinePlayersByName = Collections.unmodifiableMap(realOfflinePlayersByName);
	}
	
	
}
