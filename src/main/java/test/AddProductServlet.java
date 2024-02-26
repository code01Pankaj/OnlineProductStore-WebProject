package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
	    ServletException,IOException{
		HttpSession hs = req.getSession();
		//Access exiting Session object
		if(hs==null) {
			req.setAttribute("msg", "Session expired....<br>");
			//RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
		//	rd.forward(req, res);
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}else {

			ProductBean pb = new ProductBean();//Bean class
			pb.setpCode(req.getParameter("code"));
			pb.setpName(req.getParameter("name"));
			pb.setpPrice(Float.parseFloat(req.getParameter("price")));
			pb.setpQty(Integer.parseInt(req.getParameter("qty")));
			
			int k = new AddProduuctDAO().insert(pb);
			if(k>0) {
				req.setAttribute("msg", "Product Added Successfully....<br>");
				req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
		
			}
		}
	}
	
		
		}
	


