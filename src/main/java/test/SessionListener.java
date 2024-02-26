package test;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebListener
public class SessionListener implements HttpSessionListener,
HttpSessionAttributeListener{
	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		System.out.println("Session Created.....");
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		System.out.println("Session Destroyed....");
	}
	@Override
	public void attributeAdded(HttpSessionBindingEvent hsbe) {
		System.out.println("Attribute added to Sesson....");
		String aName = hsbe.getName();
		System.out.println("AttributeName:"+aName);
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent hsbe) {
		System.out.println("Attribute removed to Session..."); 
	}
	

}
