package io.github.thebusybiscuit.cscorelib2.protection.modules;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;

import io.github.thebusybiscuit.cscorelib2.protection.ProtectableAction;
import io.github.thebusybiscuit.cscorelib2.protection.ProtectionModule;

public class FactionsUUIDProtectionModule implements ProtectionModule {

	private FPlayers api;
	
	@Override
	public void load() {
		api = FPlayers.getInstance();
	}
	
	@Override
	public boolean hasPermission(OfflinePlayer p, Location l, ProtectableAction action) {
		Faction faction = Board.getInstance().getFactionAt(new FLocation(l));
		if (faction == null || faction.getId().equals("0")) return true;
		
		return faction.getId().equals(api.getByOfflinePlayer(p).getFaction().getId());
	}

	@Override
	public String getName() {
		return "Factions";
	}

}
