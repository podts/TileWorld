package com.podts.tileworld.persistent;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.podts.tileworld.OfflinePlayer;
import com.podts.tileworld.Player;

public interface AsynchronousPersistentManager extends PersistentManager {
	
	public Future<Boolean> playerExistsAsync(UUID id);
	
	public default boolean playerExists(UUID id) {
		try {
			return playerExistsAsync(id).get();
		} catch (InterruptedException | ExecutionException e) {
			return false;
		}
	}
	
	//Loads
	public Future<OfflinePlayer> loadOfflinePlayerAsync(UUID id);
	public Future<Player> loadPlayerAsync(UUID id);
	
	public default OfflinePlayer loadOfflinePlayer(UUID id) {
		try {
			return loadOfflinePlayerAsync(id).get();
		} catch (InterruptedException | ExecutionException e) {
			return null;
		}
	}
	
	public default Player loadPlayer(UUID id) {
		try {
			return loadPlayerAsync(id).get();
		} catch (InterruptedException | ExecutionException e) {
			return null;
		}
	}
	
	//Saves
	public Future<Boolean> saveOfflinePlayerAsync(OfflinePlayer p);
	public Future<Boolean> savePlayerAsync(Player p);
	
	public default boolean saveOfflinePlayer(OfflinePlayer p) {
		try {
			return saveOfflinePlayerAsync(p).get();
		} catch (InterruptedException | ExecutionException e) {
			return false;
		}
	}
	
	public default boolean savePlayer(Player p) {
		try {
			return savePlayerAsync(p).get();
		} catch (InterruptedException | ExecutionException e) {
			return false;
		}
	}
	
}
