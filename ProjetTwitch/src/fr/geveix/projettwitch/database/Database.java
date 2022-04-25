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
	
	public boolean updateInventory(Player player) {
		String item_1 = "air";
		String item_2 = "air";
		String item_3 = "air";
		String item_4 = "air";
		String item_5 = "air";
		String item_6 = "air";
		String item_7 = "air";
		String item_8 = "air";
		String item_9 = "air";
		String item_10 = "air";
		String item_11 = "air";
		String item_12 = "air";
		String item_13 = "air";
		String item_14 = "air";
		String item_15 = "air";
		String item_16 = "air";
		String item_17 = "air";
		String item_18 = "air";
		String item_19 = "air";
		String item_20 = "air";
		String item_21 = "air";
		String item_22 = "air";
		String item_23 = "air";
		String item_24 = "air";
		String item_25 = "air";
		String item_26 = "air";
		String item_27 = "air";
		String item_28 = "air";
		String item_29 = "air";
		String item_30 = "air";
		String item_31 = "air";
		String item_32 = "air";
		String item_33 = "air";
		String item_34 = "air";
		String item_35 = "air";
		String item_36 = "air";
		
		int itemCount_1 = 0;
		int itemCount_2 = 0;
		int itemCount_3 = 0;
		int itemCount_4 = 0;
		int itemCount_5 = 0;
		int itemCount_6 = 0;
		int itemCount_7 = 0;
		int itemCount_8 = 0;
		int itemCount_9 = 0;
		int itemCount_10 = 0;
		int itemCount_11 = 0;
		int itemCount_12 = 0;
		int itemCount_13 = 0;
		int itemCount_14 = 0;
		int itemCount_15 = 0;
		int itemCount_16 = 0;
		int itemCount_17 = 0;
		int itemCount_18 = 0;
		int itemCount_19 = 0;
		int itemCount_20 = 0;
		int itemCount_21 = 0;
		int itemCount_22 = 0;
		int itemCount_23 = 0;
		int itemCount_24 = 0;
		int itemCount_25 = 0;
		int itemCount_26 = 0;
		int itemCount_27 = 0;
		int itemCount_28 = 0;
		int itemCount_29 = 0;
		int itemCount_30 = 0;
		int itemCount_31 = 0;
		int itemCount_32 = 0;
		int itemCount_33 = 0;
		int itemCount_34 = 0;
		int itemCount_35 = 0;
		int itemCount_36 = 0;
		
		if(player.getInventory().getItem(1) != null) {  item_1 = player.getInventory().getItem(1).getType().toString().toLowerCase(); itemCount_1 = player.getInventory().getItem(1).getAmount(); }
		if(player.getInventory().getItem(2) != null) {  item_2 = player.getInventory().getItem(2).getType().toString().toLowerCase(); itemCount_2 = player.getInventory().getItem(2).getAmount(); }
		if(player.getInventory().getItem(3) != null) {  item_3 = player.getInventory().getItem(3).getType().toString().toLowerCase(); itemCount_3 = player.getInventory().getItem(3).getAmount(); }
		if(player.getInventory().getItem(4) != null) {  item_4 = player.getInventory().getItem(4).getType().toString().toLowerCase(); itemCount_4 = player.getInventory().getItem(4).getAmount(); }
		if(player.getInventory().getItem(5) != null) {  item_5 = player.getInventory().getItem(5).getType().toString().toLowerCase(); itemCount_5 = player.getInventory().getItem(5).getAmount(); }
		if(player.getInventory().getItem(6) != null) {  item_6 = player.getInventory().getItem(6).getType().toString().toLowerCase(); itemCount_6 = player.getInventory().getItem(6).getAmount(); }
		if(player.getInventory().getItem(7) != null) {  item_7 = player.getInventory().getItem(7).getType().toString().toLowerCase(); itemCount_7 = player.getInventory().getItem(7).getAmount(); }
		if(player.getInventory().getItem(8) != null) {  item_8 = player.getInventory().getItem(8).getType().toString().toLowerCase(); itemCount_8 = player.getInventory().getItem(8).getAmount(); }
		if(player.getInventory().getItem(9) != null) {  item_9 = player.getInventory().getItem(9).getType().toString().toLowerCase(); itemCount_9 = player.getInventory().getItem(9).getAmount(); }
		if(player.getInventory().getItem(10) != null) {  item_10 = player.getInventory().getItem(10).getType().toString().toLowerCase(); itemCount_10 = player.getInventory().getItem(10).getAmount(); }
		if(player.getInventory().getItem(11) != null) {  item_11 = player.getInventory().getItem(11).getType().toString().toLowerCase(); itemCount_11 = player.getInventory().getItem(11).getAmount(); }
		if(player.getInventory().getItem(12) != null) {  item_12 = player.getInventory().getItem(12).getType().toString().toLowerCase(); itemCount_12 = player.getInventory().getItem(12).getAmount(); }
		if(player.getInventory().getItem(13) != null) {  item_13 = player.getInventory().getItem(13).getType().toString().toLowerCase(); itemCount_13 = player.getInventory().getItem(13).getAmount(); }
		if(player.getInventory().getItem(14) != null) {  item_14 = player.getInventory().getItem(14).getType().toString().toLowerCase(); itemCount_14 = player.getInventory().getItem(14).getAmount(); }
		if(player.getInventory().getItem(15) != null) {  item_15 = player.getInventory().getItem(15).getType().toString().toLowerCase(); itemCount_15 = player.getInventory().getItem(15).getAmount(); }
		if(player.getInventory().getItem(16) != null) {  item_16 = player.getInventory().getItem(16).getType().toString().toLowerCase(); itemCount_16 = player.getInventory().getItem(16).getAmount(); }
		if(player.getInventory().getItem(17) != null) {  item_17 = player.getInventory().getItem(17).getType().toString().toLowerCase(); itemCount_17 = player.getInventory().getItem(17).getAmount(); }
		if(player.getInventory().getItem(18) != null) {  item_18 = player.getInventory().getItem(18).getType().toString().toLowerCase(); itemCount_18 = player.getInventory().getItem(18).getAmount(); }
		if(player.getInventory().getItem(19) != null) {  item_19 = player.getInventory().getItem(19).getType().toString().toLowerCase(); itemCount_19 = player.getInventory().getItem(19).getAmount(); }
		if(player.getInventory().getItem(20) != null) {  item_20 = player.getInventory().getItem(20).getType().toString().toLowerCase(); itemCount_20 = player.getInventory().getItem(20).getAmount(); }
		if(player.getInventory().getItem(21) != null) {  item_21 = player.getInventory().getItem(21).getType().toString().toLowerCase(); itemCount_21 = player.getInventory().getItem(21).getAmount(); }
		if(player.getInventory().getItem(22) != null) {  item_22 = player.getInventory().getItem(22).getType().toString().toLowerCase(); itemCount_22 = player.getInventory().getItem(22).getAmount(); }
		if(player.getInventory().getItem(23) != null) {  item_23 = player.getInventory().getItem(23).getType().toString().toLowerCase(); itemCount_23 = player.getInventory().getItem(23).getAmount(); }
		if(player.getInventory().getItem(24) != null) {  item_24 = player.getInventory().getItem(24).getType().toString().toLowerCase(); itemCount_24 = player.getInventory().getItem(24).getAmount(); }
		if(player.getInventory().getItem(25) != null) {  item_25 = player.getInventory().getItem(25).getType().toString().toLowerCase(); itemCount_25 = player.getInventory().getItem(25).getAmount(); }
		if(player.getInventory().getItem(26) != null) {  item_26 = player.getInventory().getItem(26).getType().toString().toLowerCase(); itemCount_26 = player.getInventory().getItem(26).getAmount(); }
		if(player.getInventory().getItem(27) != null) {  item_27 = player.getInventory().getItem(27).getType().toString().toLowerCase(); itemCount_27 = player.getInventory().getItem(27).getAmount(); }
		if(player.getInventory().getItem(28) != null) {  item_28 = player.getInventory().getItem(28).getType().toString().toLowerCase(); itemCount_28 = player.getInventory().getItem(28).getAmount(); }
		if(player.getInventory().getItem(29) != null) {  item_29 = player.getInventory().getItem(29).getType().toString().toLowerCase(); itemCount_29 = player.getInventory().getItem(29).getAmount(); }
		if(player.getInventory().getItem(30) != null) {  item_30 = player.getInventory().getItem(30).getType().toString().toLowerCase(); itemCount_30 = player.getInventory().getItem(30).getAmount(); }
		if(player.getInventory().getItem(31) != null) {  item_31 = player.getInventory().getItem(31).getType().toString().toLowerCase(); itemCount_31 = player.getInventory().getItem(31).getAmount(); }
		if(player.getInventory().getItem(32) != null) {  item_32 = player.getInventory().getItem(32).getType().toString().toLowerCase(); itemCount_32 = player.getInventory().getItem(32).getAmount(); }
		if(player.getInventory().getItem(33) != null) {  item_33 = player.getInventory().getItem(33).getType().toString().toLowerCase(); itemCount_33 = player.getInventory().getItem(33).getAmount(); }
		if(player.getInventory().getItem(34) != null) {  item_34 = player.getInventory().getItem(34).getType().toString().toLowerCase(); itemCount_34 = player.getInventory().getItem(34).getAmount(); }
		if(player.getInventory().getItem(35) != null) {  item_35 = player.getInventory().getItem(35).getType().toString().toLowerCase(); itemCount_35 = player.getInventory().getItem(35).getAmount(); }
		if(player.getInventory().getItem(36) != null) {  item_36 = player.getInventory().getItem(36).getType().toString().toLowerCase(); itemCount_36 = player.getInventory().getItem(36).getAmount(); }
		
		
		Connection con = this.main.getDatabaseConnector().getConnection();
		PreparedStatement ps = null;
		
		if(con == null ) {
			this.main.getDatabaseConnector().getConnection();
		} else {
			try {
				String sql = "UPDATE user SET inventory_1 = ?,"
						+ "inventory_2 = ?,"
						+ "inventory_3 = ?,"
						+ "inventory_4 = ?,"
						+ "inventory_5 = ?,"
						+ "inventory_6 = ?,"
						+ "inventory_7 = ?,"
						+ "inventory_8 = ?,"
						+ "inventory_9 = ?,"
						+ "inventory_10 = ?,"
						+ "inventory_11 = ?,"
						+ "inventory_12 = ?,"
						+ "inventory_13 = ?,"
						+ "inventory_14 = ?,"
						+ "inventory_15 = ?,"
						+ "inventory_16 = ?,"
						+ "inventory_17 = ?,"
						+ "inventory_18 = ?,"
						+ "inventory_19 = ?,"
						+ "inventory_20 = ?,"
						+ "inventory_21 = ?,"
						+ "inventory_22 = ?,"
						+ "inventory_23 = ?,"
						+ "inventory_24 = ?,"
						+ "inventory_25 = ?,"
						+ "inventory_26 = ?,"
						+ "inventory_27 = ?,"
						+ "inventory_28 = ?,"
						+ "inventory_29 = ?,"
						+ "inventory_30 = ?,"
						+ "inventory_31 = ?,"
						+ "inventory_32 = ?,"
						+ "inventory_33 = ?,"
						+ "inventory_34 = ?,"
						+ "inventory_35 = ?,"
						+ "inventory_36 = ?,"
						+ "inventory_1_count = ?,"
						+ "inventory_2_count = ?, "
						+ "inventory_3_count = ?,"
						+ "inventory_4_count = ?,"
						+ "inventory_5_count = ?,"
						+ "inventory_6_count = ?, "
						+ "inventory_7_count = ?, "
						+ "inventory_8_count = ?,"
						+ "inventory_9_count = ?, "
						+ "inventory_10_count = ?,"
						+ "inventory_11_count = ?,"
						+ "inventory_12_count = ?, "
						+ "inventory_13_count = ?,"
						+ "inventory_14_count = ?,"
						+ "inventory_15_count = ?,"
						+ "inventory_16_count = ?,"
						+ "inventory_17_count = ?,"
						+ "inventory_18_count = ?, "
						+ "inventory_19_count = ?, "
						+ "inventory_20_count = ?, "
						+ "inventory_21_count = ?, "
						+ "inventory_22_count = ?, "
						+ "inventory_23_count = ?,"
						+ "inventory_24_count = ?,"
						+ "inventory_25_count = ?, "
						+ "inventory_26_count = ?,"
						+ "inventory_27_count = ?,"
						+ "inventory_28_count = ?,"
						+ "inventory_29_count = ?,"
						+ "inventory_30_count = ?,"
						+ "inventory_31_count = ?,"
						+ "inventory_32_count = ?,"
						+ "inventory_33_count = ?,"
						+ "inventory_34_count = ?,"
						+ "inventory_35_count = ?,"
						+ "inventory_36_count = ? "
						+ "WHERE uuid = ?";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, item_1);
				ps.setString(2, item_2);
				ps.setString(3, item_3);
				ps.setString(4, item_4);
				ps.setString(5, item_5);
				ps.setString(6, item_6);
				ps.setString(7, item_7);
				ps.setString(8, item_8);
				ps.setString(9, item_9);
				ps.setString(10, item_10);
				ps.setString(11, item_11);
				ps.setString(12, item_12);
				ps.setString(13, item_13);
				ps.setString(14, item_14);
				ps.setString(15, item_15);
				ps.setString(16, item_16);
				ps.setString(17, item_17);
				ps.setString(18, item_18);
				ps.setString(19, item_19);
				ps.setString(20, item_20);
				ps.setString(21, item_21);
				ps.setString(22, item_22);
				ps.setString(23, item_23);
				ps.setString(24, item_24);
				ps.setString(25, item_25);
				ps.setString(26, item_26);
				ps.setString(27, item_27);
				ps.setString(28, item_28);
				ps.setString(29, item_29);
				ps.setString(30, item_30);
				ps.setString(31, item_31);
				ps.setString(32, item_32);
				ps.setString(33, item_33);
				ps.setString(34, item_34);
				ps.setString(35, item_35);
				ps.setString(36, item_36);
				
				ps.setLong(37, itemCount_1);
				ps.setLong(38, itemCount_2);
				ps.setLong(39, itemCount_3);
				ps.setLong(40, itemCount_4);
				ps.setLong(41, itemCount_5);
				ps.setLong(42, itemCount_6);
				ps.setLong(43, itemCount_7);
				ps.setLong(44, itemCount_8);
				ps.setLong(45, itemCount_9);
				ps.setLong(46, itemCount_10);
				ps.setLong(47, itemCount_11);
				ps.setLong(48, itemCount_12);
				ps.setLong(49, itemCount_13);
				ps.setLong(50, itemCount_14);
				ps.setLong(51, itemCount_15);
				ps.setLong(52, itemCount_16);
				ps.setLong(53, itemCount_17);
				ps.setLong(54, itemCount_18);
				ps.setLong(55, itemCount_19);
				ps.setLong(56, itemCount_20);
				ps.setLong(57, itemCount_21);
				ps.setLong(58, itemCount_22);
				ps.setLong(59, itemCount_23);
				ps.setLong(60, itemCount_24);
				ps.setLong(61, itemCount_25);
				ps.setLong(62, itemCount_26);
				ps.setLong(63, itemCount_27);
				ps.setLong(64, itemCount_28);
				ps.setLong(65, itemCount_29);
				ps.setLong(66, itemCount_30);
				ps.setLong(67, itemCount_31);
				ps.setLong(68, itemCount_32);
				ps.setLong(69, itemCount_33);
				ps.setLong(70, itemCount_34);
				ps.setLong(71, itemCount_35);
				ps.setLong(72, itemCount_36);
				
				ps.setString(73, player.getUniqueId().toString());
				
				ps.executeUpdate();
				
				System.out.println("ça fume");
			
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		
		return false;
	}
	
	
}
