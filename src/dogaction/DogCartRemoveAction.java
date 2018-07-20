package dogaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dogsvc.DogCartRemoveService;
import vo.ActionForward;
import action.Action;

public class DogCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] kindArray = request.getParameterValues("remove");
		DogCartRemoveService dogCartRemoveService = new DogCartRemoveService();
		dogCartRemoveService.cartRemove(request,kindArray);
		ActionForward forward = new ActionForward();
		forward.setPath("dogCartList.dog");
		return forward;
	}
	
}