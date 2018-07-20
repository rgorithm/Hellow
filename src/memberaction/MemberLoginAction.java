package memberaction;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import membersvc.MemberLoginService;
import vo.ActionForward;
import membervo.MemberBean;
import action.Action;

public class MemberLoginAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 
		 	HttpSession session=request.getSession();
	   		MemberBean member=new MemberBean();
	   		
	   		member.setMEMBER_ID(request.getParameter("MEMBER_ID"));
	   		member.setMEMBER_PW(request.getParameter("MEMBER_PW"));
	   		
	   		MemberLoginService memberLoginService = new MemberLoginService();
	   		boolean loginResult = memberLoginService.login(member);
	   		ActionForward forward = null;
	   		if(loginResult){
	   	    forward = new ActionForward();
	   		session.setAttribute("id", member.getMEMBER_ID());
	   		forward.setRedirect(true);
		   		if(member.getMEMBER_ID().equals("admin")) {
		   		forward.setPath("./memberListAction.me");
		   		}else {
		   		forward.setPath("./dogList.dog");
		   		}
	   		}
	   		else{
	   			response.setContentType("text/html;charset=euc-kr");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('로그인실패');");
		   		out.println("location.href='./memberLogin.me';");
		   		out.println("</script>");
	   		}
	   		return forward;
	   	}
}