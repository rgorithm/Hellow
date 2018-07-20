package membersvc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import memberdao.MemberDAO;
import membervo.MemberBean;

public class MemberModiFormService {
	public MemberBean MemberModForm(String id) {
		System.out.println("넘어오나보자");
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		MemberBean member = memberDAO.selectMember(id);
		close(con);
		return member;

	}
}
