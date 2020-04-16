package pos_java_jdbc.pos_java_jdbc;

import org.junit.Test;

import dao.UserPosDao;
import model.UserPosJava;

public class TesteBancoJDBC {
	
	@Test
	public void initBanco() {
		UserPosDao userPosDao = new UserPosDao();
		UserPosJava userPosJava = new UserPosJava();
		
		userPosJava.setId(4L);
		userPosJava.setNome("teste1");
		userPosJava.setEmail("teste1@gmail.com");
		
		userPosDao.salvar(userPosJava);
	}
}
