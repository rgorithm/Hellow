package boardaction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import action.Action;
import vo.ActionForward;

public class BoardWriteFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id!=null) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("board/qna_board_write.jsp");
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이필요합니다.')");
			out.println("location.href='memberLogin.me'");
			out.println("</script>");
		}
		return forward;
	}

}

