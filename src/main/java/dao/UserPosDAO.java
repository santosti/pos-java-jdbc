package dao;

import java.sql.Connection;

import conexaojdbc.SingleConnection;

public class UserPosDAO {
	
	private Connection connection;

	//Injeta dentro do objeto connection a instancia SingleConnection
	private UserPosDAO() {
		connection = SingleConnection.getConnection();
	}
	
	
}
