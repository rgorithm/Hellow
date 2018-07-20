package dogaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dogsvc.DogCartAddService;
import vo.ActionForward;
import dogvo.Dog;
import action.Action;

public class DogCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DogCartAddService dogCartAddService = new DogCartAddService();
		int id = Integer.parseInt(request.getParameter("id"));
		Dog cartDog = dogCartAddService.getCartDog(id);
		dogCartAddService.addCart(request,cartDog);
		ActionForward forward = new ActionForward();
		forward.setPath("dogCartList.dog");
		return forward;
	}

}
