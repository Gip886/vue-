package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * Servlet implementation class Res
 */
@WebServlet("/Res")
public class Res extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Res() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		String url="jdbc:mysql://localhost:3306/gip?";
		url+="user=root&password=123456&characterEncoding=utf-8&serverTimezone=UTC";
		
		//用来存信息的哈希表
		Map<String,String> alertInfo =new HashMap<>();
		
				try {
					Connection con=DriverManager.getConnection(url);
					Statement st=con.createStatement();
					String sql="insert into user value(?,?)";
					PreparedStatement pt=con.prepareStatement(sql);
					pt.setString(1, username);
					pt.setString(2, password);
					int i=pt.executeUpdate();
					if(i>=1) {
//						out.print("1");
						alertInfo.put("alertInfo", "注册成功");
						alertInfo.put("isRes","true");
					}
					else {
//						out.print("0");
						alertInfo.put("alertInfo", "注册失败");
						alertInfo.put("isRes","false");
					}
							
					//关闭连接
					pt.close();
					st.close();
					con.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
//					out.print("0");
					alertInfo.put("alertInfo", "注册失败");
					alertInfo.put("isRes","false");
				}finally {
					ObjectMapper om=new ObjectMapper();
					String s=om.writeValueAsString(alertInfo);
					out.print(s);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
