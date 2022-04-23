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
			this.con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/minelux", "root", "");
			System.out.println("[ProjectTwitch] Connexion � la base de donn�es");
		} catch (SQLException e) {
			System.out.println("[ProjectTwitch] Impossible de se connecter � la base de donn�es");
		}
	}
	
	public void disconnect() {
		try {
			this.con.close();
			System.out.println("[ProjectTwitch] D�connexion r�ussie !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[ProjectTwitch] Impossible de se d�connecter � la base de donn�es");
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
