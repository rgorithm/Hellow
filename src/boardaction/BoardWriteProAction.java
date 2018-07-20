package boardaction;

import java.io.PrintWriter;
import action.Action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import boardsvc.BoardWriteProService;
import vo.ActionForward;
import boardvo.BoardBean;

public class BoardWriteProAction implements Action{
	
	public ActionForward execute(HttpServletRequest
	request,HttpServletResponse response) throws Exception{
		
		ActionForward forward=null;
		BoardBean boardBean=null;
		String realFolder="";
		String saveFolder="/boardupload";
		int fileSize=5*1024*1024;
		ServletContext context=request.getServletContext();
		realFolder=context.getRealPath(saveFolder);
		MultipartRequest multi=new MultipartRequest(request,
				realFolder,
				fileSize,
				"UTF-8",
				new DefaultFileRenamePolicy());
		boardBean=new BoardBean();
		boardBean.setBOARD_NAME(multi.getParameter("BOARD_NAME"));
		boardBean.setBOARD_PASS(multi.getParameter("BOARD_PASS"));
		boardBean.setBOARD_SUBJECT(multi.getParameter("BOARD_SUBJECT"));
		boardBean.setBOARD_CONTENT(multi.getParameter("BOARD_CONTENT"));
		boardBean.setBOARD_FILE(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		BoardWriteProService boardWriteProService=new BoardWriteProService();
		boolean isWriteSuccess=boardWriteProService.
		registArticle(boardBean);
		
		if(!isWriteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('등록에 실패했습니다.')");
			out.println("history.back();");
			out.println("</script>");
		}
		else {
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("id");
			if(id!=null) {
				forward=new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardList.bo");
			}else
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
