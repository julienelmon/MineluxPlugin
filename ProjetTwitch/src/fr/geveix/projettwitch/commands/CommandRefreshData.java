package fr.geveix.projettwitch.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.geveix.projettwitch.Main;

public class CommandRefreshData implements CommandExecutor {
	
	private Main main;

	public CommandRefreshData(Main main) {
		this.main = main;
	}
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] arg) {
		if(sender instanceof Player ) {
			Player player = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("refreshdata")) {
				this.main.getDatabase().updateAccount(player);
				player.sendMessage("[ProjetTwitch] Profil mis � jour");	
				return true;
			} else {
				player.sendMessage("[ProjetTwitch] Erreur de syntaxe");	
				return false;
			}
		} else {
			if(cmd.getName().equalsIgnoreCase("refreshdata")) {
				Player player = Bukkit.getPlayer(arg[0]);
				
				if(player != null) {
					this.main.getDatabase().updateAccount(player);
					System.out.println("[ProjetTwitch] Le joueur " + player.toString() + " � �t� mise a jour");
					return true;
				} else {
					System.out.println("[ProjetTwitch] Erreur le joueur n'est pas connect� ");
					return false;
				}
			}
		}
		return false;
	}
}