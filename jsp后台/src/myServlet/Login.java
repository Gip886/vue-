package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.addHeader("Access-Control-Allow-Origin", "*");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("用户名"+username);
		System.out.println("密码"+password);
		
		String url="jdbc:mysql://localhost:3306/gip?";
		url+="user=root&password=123456&characterEncoding=utf-8&serverTimezone=UTC";
		
		//用来存信息的哈希表
		Map<String,String> alertInfo =new HashMap<>();
		
		try {
			Connection con;
			con = DriverManager.getConnection(url);
			Statement st=con.createStatement();
			String sql="select * from user";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
			//处理内容
				if(rs.getString("username").equals(username)&&rs.getString("password").equals(password)){
//					out.print("1");
					
					alertInfo.put("alertInfo", "登录成功");
					alertInfo.put("isLogin","true");
				}
			}
			//关闭连接
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			alertInfo.put("alertInfo", "登录失败");
			alertInfo.put("isLogin","false");
		}finally {
			
			ObjectMapper om=new ObjectMapper();
			String s=om.writeValueAsString(alertInfo);
			out.print(s);
		}
				
		
		
//		if("123".equals(username)) {
//			out.print("1");
//		}
//		out.print("1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
