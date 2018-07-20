package dogsvc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dogdao.DogDAO;
import dogvo.Dog;

public class DogModService {
	public boolean DogMod2(Dog dog) {
	DogDAO dogDAO = DogDAO.getInstance();
	Connection con = getConnection();
	dogDAO.setConnection(con);		
	boolean isModSuccess = false;		
	int updateCount = dogDAO.updateDog(dog);
	
	if(updateCount>0){
		commit(con);
		isModSuccess=true;
	}else{
		rollback(con);
	}
	
	close(con);
	return isModSuccess;
	}
}
