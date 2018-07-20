	package dogaction;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dogsvc.DogViewService;
import vo.ActionForward;
import dogvo.Dog;
import action.Action;

public class DogViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DogViewService dogViewService = new DogViewService();
		int id = Integer.parseInt(request.getParameter("id"));
		Dog dog = dogViewService.getDogView(id);
		request.setAttribute("dog", dog);
		Cookie todayImageCookie = new Cookie("today"+id, dog.getImage());
		todayImageCookie.setMaxAge(60*60*24);
		response.addCookie(todayImageCookie);
		ActionForward forward = new ActionForward();
		forward.setPath("/dogshopping/dogView.jsp");
		return forward;
	}
	
}