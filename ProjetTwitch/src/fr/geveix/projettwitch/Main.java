package fr.geveix.projettwitch;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.geveix.projettwitch.commands.CommandRefreshData;
import fr.geveix.projettwitch.database.Database;
import fr.geveix.projettwitch.database.DatabaseConnector;

public class Main extends JavaPlugin implements Listener {
	
	private static DatabaseConnector databaseManager;
	private static Database database;
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		getConfig().options().copyDefaults(true);
		saveConfig();
		System.out.println(this.getConfig().getString("messages.prefix") + this.getConfig().getString("messages.running"));
		databaseManager = new DatabaseConnector(this);
		database = new Database(this);
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this );
		getCommand("refreshdata").setExecutor(new CommandRefreshData(this));
	}

	@Override
	public void onDisable() {
		System.out.println(this.getConfig().getString("messages.prefix") + this.getConfig().getString("messages.shutdown"));
	}
	
	public DatabaseConnector getDatabaseConnector() {
		return databaseManager;
	}
	
	public Database getDatabase() {
		return database;
	}
	
	@EventHandler
	public void join(PlayerJoinEvent e) {
		final Player player = e.getPlayer();
		database.createAccount(player);
		database.updateInventory(player);
	}
	
	@EventHandler
	public void quit(PlayerQuitEvent e) {
		final Player player = e.getPlayer();
		database.updateAccount(player);
	}
}
