package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.UserPosDao;
import model.BeanUserFone;
import model.Telefone;
import model.UserPosJava;

public class TesteBancoJDBC {

	@Test
	public void initBanco() {
		UserPosDao userPosDao = new UserPosDao();
		UserPosJava userPosJava = new UserPosJava();

		userPosJava.setNome("teste3");
		userPosJava.setEmail("teste3@gmail.com");

		userPosDao.salvar(userPosJava);
	}

	@Test
	public void initListar() {
		UserPosDao dao = new UserPosDao();

		try {
			List<UserPosJava> list = dao.listar();

			for (UserPosJava userPosJava : list) {
				System.out.println(userPosJava);
				System.out.println("-------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initBuscar() {
		UserPosDao dao = new UserPosDao();
		try {
			UserPosJava userPosJava = dao.buscar(3L);
			System.out.println(userPosJava);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initAtualizar() {
		try {
			UserPosDao dao = new UserPosDao();

			UserPosJava objetoBanco = dao.buscar(5L);
			objetoBanco.setNome("teste2");
			dao.atualizar(objetoBanco);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initDeletar() {
		try {
			UserPosDao dao = new UserPosDao();
			dao.deletar(null); // Insere a id a ser deletada aqui.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testeInsertTelefone() {
		Telefone telefone = new Telefone();

		telefone.setNumero("(62)9 66-2222");
		telefone.setTipo("Casa");
		telefone.setUsuario(1L);

		UserPosDao dao = new UserPosDao();
		dao.salvarTelefone(telefone);
	}

	@Test
	public void testeCarregaFonesUser() {
		UserPosDao dao = new UserPosDao();

		List<BeanUserFone> beanUserFones = dao.listaUserFone(11L);

		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("-------------------------------");

		}
	}

	@Test
	public void testeDeleteUserFone() {
		UserPosDao dao = new UserPosDao();

		dao.deleteFonesPorUser(11L);
	}

}
