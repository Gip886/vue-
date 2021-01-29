package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * Servlet implementation class load
 */
@WebServlet("/load")
public class load extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public load() {
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
		
		String username=request.getParameter("username");
		System.out.println("LoadΩ” ‹username"+username);
		
		
Map<String,String> alertInfo =new HashMap<>();
List<musicData> musics=new ArrayList<musicData>();
		
		String url="jdbc:mysql://localhost:3306/gip?";
		url+="user=root&password=123456&characterEncoding=utf-8&serverTimezone=UTC";
		Connection con;
		try {
			con = DriverManager.getConnection(url);
			
			String sql=" select music.*,record.* from music inner join record on music.id=record.id";
			PreparedStatement pt=con.prepareStatement(sql);

			
			ResultSet rs =pt.executeQuery();
			while(rs.next()) {
				int id =rs.getInt("id");
				String name =rs.getString("name");
				String musicurl =rs.getString("musicurl");
				String singer =rs.getString("singer");
				String coverUrl =rs.getString("coverUrl");
				Date time =rs.getDate("time");
				
				musicData data = new musicData();
				data.setId(id);
				data.setName(name);
				data.setMusicurl(musicurl);
				data.setSinger(singer);
				data.setCoverUrl(coverUrl);
				data.setTime(time);
				
				musics.add(data);
			}

			
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}finally{
			ObjectMapper om=new ObjectMapper();
			String s=om.writeValueAsString(musics);
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
