package dogaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dogsvc.DogCartQtyUpService;
import vo.ActionForward;
import action.Action;

public class DogCartQtyUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String kind = request.getParameter("kind");
		DogCartQtyUpService dogCartQtyUpService = new DogCartQtyUpService();
		dogCartQtyUpService.upCartQty(kind,request);
		ActionForward forward = new ActionForward();
		forward.setPath("dogCartList.dog");
		return forward;
	}

}
