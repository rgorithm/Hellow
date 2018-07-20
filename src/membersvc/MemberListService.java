package membersvc;

import java.sql.Connection;
import java.util.ArrayList;
import memberdao.MemberDAO;
import static db.JdbcUtil.*;
import membervo.MemberBean;

public class MemberListService {

	public ArrayList<MemberBean> getMemberList() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		ArrayList<MemberBean> memberList = memberDAO.selectMemberList();
		close(con);
		return memberList;
	}

}
