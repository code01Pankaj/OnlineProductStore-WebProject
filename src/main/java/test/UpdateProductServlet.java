package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet{
@SuppressWarnings("unchecked")
@Override
 protected void doPost(HttpServletRequest req,HttpServletResponse res)
     throws ServletException,IOException{
     HttpSession hs = req.getSession(false);
     if(hs==null) {
                req.setAttribute("msg","Session expired...<br>");
                req.getRequestDispatcher("Home.jsp").forward(req, res);
                }else {
                    String pCode = req.getParameter("code");
                    ArrayList<ProductBean> al = (ArrayList<ProductBean>)hs.getAttribute("al");
                    Iterator<ProductBean> it = al.iterator();
                 while(it.hasNext()) {
	              ProductBean pb = (ProductBean)it.next();
	              if(pCode.equals(pb.getpCode())) {
	               pb.setpPrice(Float.parseFloat(req.getParameter("price")));
	               pb.setpQty(Integer.parseInt(req.getParameter("qty")));
	           int k = new UpdateProductDAO().update(pb);
              	 if(k>0) {
	                req.setAttribute("msg", "Product Updated Successfully...<br>");
	                 }//end of if
	            break;
	               }//end of if
	              }//end of loop
	           req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
	   }
	  }
	 }