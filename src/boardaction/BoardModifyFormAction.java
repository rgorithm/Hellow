package boardaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import boardsvc.BoardDetailService;
import vo.ActionForward;
import boardvo.BoardBean;
import action.Action;
public class BoardModifyFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 	ActionForward forward = new ActionForward();
			int board_num=Integer.parseInt(request.getParameter("board_num"));
			String nowPage=request.getParameter("page");
			BoardDetailService boardDetailService = new BoardDetailService();	
		   	BoardBean article = boardDetailService.getArticle(board_num);
		   	request.setAttribute("article", article);
		   	request.setAttribute("page", nowPage);
	   		forward.setPath("/board/qna_board_modify.jsp");
	   		return forward;
	   		
	 }
	 
}