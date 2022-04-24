package fr.geveix.projettwitch.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.geveix.projettwitch.Main;

public class Database {
	
	private Main main;

	public Database(Main main) {
		this.main = main;
	}
	
	public boolean hasAccount(Player player) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = this.main.getDatabaseConnector().getConnection();
		if(con != null) {
			try {
				String sql = "SELECT uuid FROM user WHERE 'uuid' = ? LIMIT 1 ";
				ps = con.prepareStatement(sql);
				ps.setString(1, player.getUniqueId().toString());
				rs = ps.executeQuery();
				if(rs.next()) 
					return true;
				
			} catch (SQLException e) {
				System.out.println(this.main.getConfig().getString("messages.prefix") + 
						this.main.getConfig().getString("messages.dberror"));
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) 
						rs.close();
					if (ps != null) 
						ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	public boolean createAccount(Player player) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = this.main.getDatabaseConnector().getConnection();
		if(con != null) {
			try {
				String sql = "SELECT uuid FROM user WHERE 'pseudo' = ? LIMIT 1 ";
				ps = con.prepareStatement(sql);
				ps.setString(1, player.getName().toString());
				rs = ps.executeQuery();
				if(!rs.next()) {
					String sql2 = "UPDATE user SET uuid = ?, experience = ?, feed = ?, health = ? WHERE pseudo = ?";
					ps = con.prepareStatement(sql2);
					ps.setString(1, player.getUniqueId().toString());
					ps.setLong(2, player.getTotalExperience());
					ps.setLong(3, player.getFoodLevel());
					ps.setLong(4, (long) player.getHealth());
					ps.setString(5, player.getName().toString());
					System.out.println(this.main.getConfig().getString("messages.prefix") + 
							this.main.getConfig().getString("messages.playercreated"));
					ps.executeUpdate();
				} else {
					updateAccount(player);
				}
					
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			
		}
		return true;
	}
	
	public boolean updateAccount(Player player) {
		PreparedStatement ps = null;
		Connection con = this.main.getDatabaseConnector().getConnection();
		if(con != null) {
			if(hasAccount(player) == true) {
				try {
					String sql = "UPDATE user SET experience = ?, feed = ?, health = ? WHERE uuid = ? ";
					ps = con.prepareStatement(sql);
					ps.setLong(1, player.getTotalExperience());
					ps.setLong(2, player.getFoodLevel());
					ps.setLong(3, (long) player.getHealth());
					ps.setString(4, player.getUniqueId().toString());
					System.out.println(this.main.getConfig().getString("messages.prefix") + 
							this.main.getConfig().getString("messages.playercreated"));
					ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			} else {
				createAccount(player);
			}
		}
	return true;
	}
	
	public int updateInventory(Player player) {
		
		int amount = 0;
		for (int i = 0; i < 36; i++) {
			System.out.println("test");
			ItemStack slot = player.getInventory().getItem(i);
			amount += slot.getAmount();
		}
		return 1;
	}
	
	
}
