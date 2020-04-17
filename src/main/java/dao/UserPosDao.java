package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			// Salva no banco
			connection.commit();

		} catch (Exception e) {
			try {
				// Reverte a operação caso ocorra algum erro
				connection.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public List<UserPosJava> listar() throws SQLException {

		List<UserPosJava> list = new ArrayList<UserPosJava>();

		String sql = "select * from userposjava";

		// Prepara o sql
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		// Seta valores no objeto
		while (resultado.next()) {
			UserPosJava userPosJava = new UserPosJava();

			userPosJava.setId(resultado.getLong("id"));
			userPosJava.setNome(resultado.getString("nome"));
			userPosJava.setEmail(resultado.getString("email"));

			list.add(userPosJava);
		}

		return list;
	}

	public UserPosJava buscar(Long id) throws SQLException {
		UserPosJava retorno = new UserPosJava();

		String sql = "select * from userposjava where id =" + id;

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));
		}
		return retorno;

	}

}
