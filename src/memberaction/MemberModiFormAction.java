package memberaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membersvc.MemberModiFormService;
import vo.ActionForward;
import membervo.MemberBean;
import action.Action;

public class MemberModiFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		MemberModiFormService memberModFormService = new MemberModiFormService();
		String id = request.getParameter("id");
		MemberBean member = memberModFormService.MemberModForm(id);
		request.setAttribute("member",member);
		forward.setPath("member_modiForm.jsp");
		System.out.println("ddd");
		return forward;
	}

}
