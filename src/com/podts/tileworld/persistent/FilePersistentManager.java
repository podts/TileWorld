package com.podts.tileworld.persistent;

import java.util.UUID;
import java.util.concurrent.Future;

import com.podts.tileworld.OfflinePlayer;
import com.podts.tileworld.Player;

public class FilePersistentManager implements AsynchronousPersistentManager {
	
	@Override
	public Future<Boolean> playerExistsAsync(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<OfflinePlayer> loadOfflinePlayerAsync(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<Player> loadPlayerAsync(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<Boolean> saveOfflinePlayerAsync(OfflinePlayer p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<Boolean> savePlayerAsync(Player p) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
