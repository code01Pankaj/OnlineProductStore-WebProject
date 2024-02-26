package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		HttpSession hs=req.getSession();

		if(hs==null) {
			req.setAttribute("msg", "Session Expired......<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);

		}else {
			
			req.setAttribute("msg","LoggedOut Successfully...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);

		}
	}

}
