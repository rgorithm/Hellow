package dogsvc;

import dogdao.DogDAO;
import static db.JdbcUtil.*;
import java.sql.Connection;
import dogvo.Dog;

public class DogDelService {
	public int deleteDog(int id) {
		Connection con = getConnection();
		DogDAO dogDAO = DogDAO.getInstance();
		dogDAO.setConnection(con);
		int deleteCount = dogDAO.deleteDog(id);
		
		if(deleteCount>0) {
			commit(con);
		}else {
			rollback(con);
		}
		return deleteCount;
	}

}
