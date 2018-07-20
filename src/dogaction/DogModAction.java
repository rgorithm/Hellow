package dogaction;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import dogsvc.DogModFormService;
import dogsvc.DogModService;
import vo.ActionForward;
import dogvo.Dog;
import action.Action;

public class DogModAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		DogModFormService DogModFormService = new DogModFormService();
		String realFolder = "";
		System.out.println("되나여");
		String saveFolder = "/images";
		String encType = "UTF-8";
		int maxSize = 5*1024*1024;
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request,
					realFolder, maxSize, encType);
		String image = multi.getFilesystemName("image");
		int id = Integer.parseInt(multi.getParameter("id"));
		System.out.println(id);
		Dog dog = new Dog(
				id, 
				multi.getParameter("kind"), 
				Integer.parseInt(multi.getParameter("price")), 
				image, 
				multi.getParameter("nation"), 
				Integer.parseInt(multi.getParameter("height")), 
				Integer.parseInt(multi.getParameter("weight")), 
				multi.getParameter("content"), 
				0);
		DogModService dogModService = new DogModService();
		boolean isRegistSuccess = dogModService.DogMod2(dog);
		ActionForward forward = null;
		
		if(isRegistSuccess){
			forward = new ActionForward();
			forward.setPath("/dogList.dog");
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
