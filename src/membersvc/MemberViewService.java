package membersvc;

import membervo.MemberBean;
import static db.JdbcUtil.*;
import java.sql.Connection;
import memberdao.MemberDAO;

public class MemberViewService {

	public MemberBean getMember(String viewId) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		MemberBean member = memberDAO.selectMember(viewId);
		close(con);
		return member;
	}

}
