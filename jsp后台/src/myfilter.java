

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
//        //����������Դ��������
		
		//�������session����Ϊ1
//		String origin=request.getHeader("origin");
//		response.setHeader("access-control-allow-origin", origin);
		
		//2.�ڷ�������ʹ��session
		response.setHeader("access-control-allow-credentials", "true");
		//Ϊʹ��session,axios��������:axios.defaults.withCredentials = true
		//ʹ��response����֮ǰ��������ȫ������ 
		 
                
        
		//����Я������ͷ��Ϣ��������user,tokenΪ�Զ���ͷ��Ϣ
		response.setHeader("access-control-allow-headers", "user,token");
		
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	       System.out.println("ͨ��������");
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
