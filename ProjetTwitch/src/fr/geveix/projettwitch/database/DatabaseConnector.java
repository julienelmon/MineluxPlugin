package fr.geveix.projettwitch.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.geveix.projettwitch.Main;

public class DatabaseConnector {
	
	private Connection con = null;
	
	private Main main;
	
	public DatabaseConnector(Main main) {
		this.main = main;
		connect();
	}


	public void connect() {
		try {
			this.con = DriverManager.getConnection("jdbc:mysql://" + 
					this.main.getConfig().getString("database.host") + ":" + 
					this.main.getConfig().getString("database.port") + "/" + 
					this.main.getConfig().getString("database.name"), 
					this.main.getConfig().getString("database.user"), 
					this.main.getConfig().getString("database.password"));
			System.out.println(this.main.getConfig().getString("messages.prefix") + 
					this.main.getConfig().getString("messages.dbconnected"));
		} catch (SQLException e) {
			System.out.println(this.main.getConfig().getString("messages.prefix") + 
					this.main.getConfig().getString("messages.dberror"));
		}
	}
	
	public void disconnect() {
		try {
			this.con.close();
			System.out.println(this.main.getConfig().getString("messages.prefix") + 
					this.main.getConfig().getString("messages.dbdisconnected"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(this.main.getConfig().getString("messages.prefix") + 
					this.main.getConfig().getString("messages.dberror"));
		}
	}
	
	public Connection getConnection() {
		checkConnection();
		return this.con;
	}
	
	public void checkConnection() {
		if(this.con == null) {
			connect();
		}
	}
}
