package boardsvc;

import java.sql.Connection;
import boarddao.BoardDAO;
import boardvo.BoardBean;
import static db.JdbcUtil.*;
public class BoardWriteProService{
	
	public boolean registArticle(BoardBean boardBean)throws
	Exception{
		boolean isWriteSuccess=false;
		Connection con=getConnection1();
		BoardDAO boardDAO=BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int insertCount=boardDAO.insertArticle(boardBean);
		
		if(insertCount>0) {
			commit(con);
			isWriteSuccess=true;
		}
		else {
			rollback(con);
		}
		close(con);
		return isWriteSuccess;
	}
}
