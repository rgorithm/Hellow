package dogsvc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dogdao.DogDAO;
import dogvo.Dog;

public class DogModFormService {
	public Dog DogModForm(int id) {
		System.out.println("넘어오나보자");
		Connection con = getConnection();
		DogDAO dogDAO = DogDAO.getInstance();
		dogDAO.setConnection(con);	
		Dog dog = dogDAO.selectDog(id);
		close(con);
		return dog;
	}

}
