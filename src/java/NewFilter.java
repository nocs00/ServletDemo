import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class NewFilter implements Filter {
    
    public void init(FilterConfig filterConfig) {
        // init parameter
        String value = filterConfig.getInitParameter("newParam");
        // displaying init parameter value
        System.out.println("The Parameter value: " + value);
    }
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // IP address of the client machine.
        String remoteAddress = request.getRemoteAddr();
        // Returns the remote address
        System.out.println("Remote Internet Protocl Address: "+ remoteAddress);
        chain.doFilter(request,response);
    }
    
    public void destroy() {
        
    }
}