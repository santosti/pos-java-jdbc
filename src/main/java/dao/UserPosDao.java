package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conexaojdbc.SingleConnection;
import model.UserPosJava;

public class UserPosDao {

	private Connection connection;

	// Injeta dentro do objeto connection a instancia SingleConnection
	public UserPosDao() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(UserPosJava userPosJava) {
		try {
			String sql = "Insert into userPosJava(id, nome, email) values (?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setLong(1, userPosJava.getId());
			insert.setString(2, userPosJava.getNome());
			insert.setString(3, userPosJava.getEmail());
			
			insert.execute();
			//Salva no banco
			connection.commit(); 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
