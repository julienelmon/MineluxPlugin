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
				player.sendMessage(this.main.getConfig().getString("messages.prefix") + this.main.getConfig().getString("messages.updateprofile"));	
				return true;
			} else {
				player.sendMessage(this.main.getConfig().getString("messages.prefix") + this.main.getConfig().getString("messages.syntaxerror"));	
				return false;
			}
		} else {
			if(cmd.getName().equalsIgnoreCase("refreshdata")) {
				Player player = Bukkit.getPlayer(arg[0]);
				
				if(player != null) {
					this.main.getDatabase().updateAccount(player);
					System.out.println(this.main.getConfig().getString("messages.prefix") + 
							this.main.getConfig().getString("messages.playerupdatedprefix") + 
							player.toString() + 
							this.main.getConfig().getString("messages.playerupdatedsuffix"));
					return true;
				} else {
					System.out.println(this.main.getConfig().getString("messages.connecterror"));
					return false;
				}
			}
		}
		return false;
	}
}
