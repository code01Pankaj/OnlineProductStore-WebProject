package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/viewProducts")
public class ViewAllProductsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		HttpSession hs = req.getSession(false);
	    if(hs==null) {
	    	req.setAttribute("msg", "Session Expired...<br>");
	        RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
	        rd.forward(req, res);
	    }else {
	    	ArrayList<ProductBean> al = new ViewAllProductDAO().retrieve();
	    	hs.setAttribute("al", al);
	    	RequestDispatcher rd = req.getRequestDispatcher("ViewAllProducts.jsp");
	    	rd.forward(req, res);
	    }//end of else
	}//end of if
}