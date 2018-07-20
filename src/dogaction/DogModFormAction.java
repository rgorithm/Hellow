package dogaction;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dogsvc.DogModFormService;
import vo.ActionForward;
import dogvo.Dog;
import action.Action;

public class DogModFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("넘어오나");
		DogModFormService dogModFormService = new DogModFormService();
		int id = Integer.parseInt(request.getParameter("id"));
		Dog dog = dogModFormService.DogModForm(id);
		request.setAttribute("dog", dog);
		ActionForward forward = new ActionForward();
		forward.setPath("dogshopping/dogModForm.jsp");
		return forward;
	}

}
