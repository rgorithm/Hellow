package dogaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dogsvc.DogCartQtyDownService;
import vo.ActionForward;
import action.Action;

public class DogCartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String kind = request.getParameter("kind");
		System.out.println("kind = " + kind);
		DogCartQtyDownService dogCartQtyDownService = new DogCartQtyDownService();
		dogCartQtyDownService.downCartQty(kind,request);
		ActionForward forward = new ActionForward();
		forward.setPath("dogCartList.dog");
		return forward;
	}

}
