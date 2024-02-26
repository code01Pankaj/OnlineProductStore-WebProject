package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebListener
public class RequestListener implements ServletRequestListener,
ServletRequestAttributeListener{
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("Request Initialized....");
	}
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
    	System.out.println("Request Destroyed....");
    }
    @Override
    public void  attributeAdded(ServletRequestAttributeEvent srae) {
    	System.out.println("Attribute added to request....");
    	String aName = srae.getName();
    	System.out.println("AttributeName:"+aName);
    }
    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
    	System.out.println("Attribute Removed from request.....");
    }
}
