package membersvc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import memberdao.MemberDAO;
import membervo.MemberBean;

public class MemberModiService {
	public int updateMember(MemberBean member) {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		int updateCount = memberDAO.modifyMember(member);
		if(updateCount>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return updateCount;
	}

}
