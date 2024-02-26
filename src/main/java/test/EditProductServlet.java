package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Sesson Expired....<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}else {
			String pCode = req.getParameter("pcode");
			@SuppressWarnings("unchecked")
			ArrayList<ProductBean> al =(ArrayList<ProductBean>) hs.getAttribute("al");
			Iterator<ProductBean> it = al.iterator();
			while(it.hasNext()) {
				ProductBean pb = (ProductBean)it.next();
				if(pCode.equals(pb.getpCode())) {
					req.setAttribute("pb", pb);
					break;//while Statement
				}
			}//end of loop
		//	RequestDispatcher rd = req.getRequestDispatcher("EditProduct.jsp");
			//rd.forward(req, res);
			//or
			req.getRequestDispatcher("EditProduct.jsp").forward(req, res);
		}
	}

}
