package dogaction;

import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import dogsvc.DogListService;
import vo.ActionForward;
import dogvo.Dog;
import action.Action;

public class DogListAction implements Action {

	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<String> todayImageList = new ArrayList<String>();
		Cookie[] cookieArray = request.getCookies();
		if(cookieArray != null){
			for (int i = 0; i < cookieArray.length; i++) {
				if(cookieArray[i].getName().startsWith("today")){
					todayImageList.add(cookieArray[i].getValue());
				}
			}
		}
		String id = (String)request.getAttribute("id");
		DogListService dogListService = new DogListService();
		ArrayList<Dog> dogList = dogListService.getDogList();
		request.setAttribute("dogList", dogList);
		request.setAttribute("todayImageList", todayImageList);
		ActionForward forward = new ActionForward();
		forward.setPath("/dogshopping/dogList.jsp");
		
		return forward;
	}
	
}
