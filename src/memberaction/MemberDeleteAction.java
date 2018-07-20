package memberaction;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import membersvc.MemberDeleteService;
import vo.ActionForward;
import action.Action;

public class MemberDeleteAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");

		ActionForward forward = null;
		if(id==null){
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./memberLogin.me");
		}else if(!id.equals("admin")){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('�����ڰ� �ƴմϴ�.');");
			out.println("location.href='./memberLogin.me';");
			out.println("</script>");
		}
		else{
			String deleteId=request.getParameter("id");
			MemberDeleteService memberDeleteService = new MemberDeleteService();
			boolean deleteResult=memberDeleteService.deleteMember(deleteId);

			if(deleteResult){
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./memberListAction.me");
			}
			else{
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('ȸ���������� ����.');");
				out.println("location.href='./memberLogin.me';");
				out.println("</script>");
			}
		}
		return forward;
	}
}