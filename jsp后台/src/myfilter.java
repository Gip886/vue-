

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class myfilter
 */
@WebFilter("/*")
public class myfilter implements Filter {

    /**
     * Default constructor. 
     */
    public myfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
//		 HttpServletResponse response1= (HttpServletResponse) response;
//		 response1.setHeader("Access-Control-Allow-Origin","*");
//	        filterChain.doFilter(servletRequest,servletResponse);
		
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res; 
		
		response.setHeader("access-control-allow-origin", "*");
//        //允许所有来源请求数据
		
		//如果启用session，改为1
//		String origin=request.getHeader("origin");
//		response.setHeader("access-control-allow-origin", origin);
		
		//2.在服务器端使用session
		response.setHeader("access-control-allow-credentials", "true");
		//为使用session,axios必须配置:axios.defaults.withCredentials = true
		//使用response对象之前设置上面全部内容 
		 
                
        
		//允许携带请求头信息！！！，user,token为自定义头信息
		response.setHeader("access-control-allow-headers", "user,token");
		
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	       System.out.println("通过过滤器");
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
