package memberaction;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import membersvc.MemberModiService;
import vo.ActionForward;
import membervo.MemberBean;
import action.Action;

public class MemberModiAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		MemberModiService memberModiService = new MemberModiService();
		String id = request.getParameter("id");
		MemberBean member = new MemberBean();
				member.setMEMBER_ID(request.getParameter("MEMBER_ID")); 
				member.setMEMBER_PW(request.getParameter("MEMBER_PW")); 
				member.setMEMBER_NAME(request.getParameter("MEMBER_NAME"));
				member.setMEMBER_AGE(Integer.parseInt(request.getParameter("MEMBER_AGE"))); 
				member.setMEMBER_GENDER(request.getParameter("MEMBER_GENDER")); 
				member.setMEMBER_EMAIL(request.getParameter("MEMBER_EMAIL"));
				int updateCount = memberModiService.updateMember(member);
				if(updateCount>0) {
					System.out.println("수정성공"+member.getMEMBER_EMAIL());
				}
				else {
					System.out.println("수정실패");
				}
				forward.setPath("memberViewAction.me?id="+id);
				return forward;
	}

}
