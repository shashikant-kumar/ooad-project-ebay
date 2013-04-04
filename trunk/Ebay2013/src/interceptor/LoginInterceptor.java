package interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor{
	 private static final long serialVersionUID = 1L;
	 
	    public String intercept(ActionInvocation invocation) throws Exception {
	 
	        String className = invocation.getAction().getClass().getName();
	        long startTime = System.currentTimeMillis();
	        System.out.println("Before calling action: " + className);
	 
	        String result = invocation.invoke();
	 
	        long endTime = System.currentTimeMillis();
	        System.out.println("After calling action: " + className
	                + " Time taken: " + (endTime - startTime) + " ms");
	        Map<String, Object> session =  
	                invocation.getInvocationContext().getSession();  
	            String actionName = invocation.getInvocationContext().getName();  
	            System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"+actionName);
	            if (!"Login".equalsIgnoreCase(actionName)||session.get("user")==null||session.get("user")=="") {  
	                session.put("lastAction", actionName);  
	            }  
	 
	        return result;
	    }
	 
	    public void destroy() {
	        System.out.println("Destroying MyLoggingInterceptor...");
	    }
	    public void init() {
	        System.out.println("Initializing MyLoggingInterceptor...");
	    }
}
