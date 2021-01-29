package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import mybean.musicData;


/**
 * Servlet implementation class addData
 */
@WebServlet("/addData")
public class addData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		 String sid =request.getParameter("id");
		 
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String singer=request.getParameter("singer");
		String musicurl=request.getParameter("url");
		String coverUrl=request.getParameter("coverUrl");
		
		String username=request.getParameter("username");
		
		System.out.println(musicurl);
		System.out.println(username);
		
		
		Map<String,String> alertInfo =new HashMap<>();
	
		
		String url="jdbc:mysql://localhost:3306/gip?";
		url+="user=root&password=123456&characterEncoding=utf-8&serverTimezone=UTC";
		Connection con;
		try {
			con = DriverManager.getConnection(url);
			String sql="insert into music value(?,?,?,?,?)";
			PreparedStatement pt=con.prepareStatement(sql);
			pt.setInt(1, id);
			pt.setString(2,name);
			pt.setString(3,musicurl);
			pt.setString(4,singer);
			pt.setString(5,coverUrl);
			
			int i=pt.executeUpdate();	
	
			String sql2="insert into record (username,id,time) value(?,?,?)";
			PreparedStatement ppt=con.prepareStatement(sql2);
			
			
			


				Date date = new Date();
				//转换成指定格式的字符串（String类型）
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
				String currentTime = sdf.format(date);
				
				ppt.setString(1,username);
				ppt.setInt(2, id);
				ppt.setString(3,currentTime);
				int j=ppt.executeUpdate();
				
				if(j>=1&&i>=1){
					alertInfo.put("alertInfo", "录入成功");
					alertInfo.put("status", "true");
				}else{
					alertInfo.put("alertInfo", "录入失败");
					alertInfo.put("status", "false");
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			alertInfo.put("alertInfo", "录入失败");
			alertInfo.put("status", "false");
		}finally{
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
