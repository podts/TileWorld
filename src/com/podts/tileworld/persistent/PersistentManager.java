package com.podts.tileworld.persistent;

import java.util.UUID;

import com.podts.tileworld.OfflinePlayer;
import com.podts.tileworld.Player;

public interface PersistentManager {
	
	public boolean playerExists(UUID id);
	
	//Loads
	public OfflinePlayer loadOfflinePlayer(UUID id);
	public Player loadPlayer(UUID id);
	
	//Saves
	public boolean saveOfflinePlayer(OfflinePlayer p);
	public boolean savePlayer(Player p);
	
}
