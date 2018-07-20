package dogaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dogsvc.DogDelService;
import vo.ActionForward;
import action.Action;

public class DogDelAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		DogDelService dogDelService = new DogDelService();
		int id = Integer.parseInt(request.getParameter("id"));
		int deleteCount = dogDelService.deleteDog(id);
		ActionForward forward = null;
		if(deleteCount>0) {
		forward = new ActionForward();
		forward.setPath("/dogList.dog");
		}else {
		forward = new ActionForward();
		forward.setPath("/dogView.dog?id="+id);
		}
		return forward;
	}

}
