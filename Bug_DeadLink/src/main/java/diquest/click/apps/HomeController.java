package diquest.click.apps;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	String gubun = "";
	String logtype = "";
	String counting = "";
	String currentPage = "";
	String rownum = "";
	String sorting = "";
	String totalsize = "";
    static String url = "jdbc:oracle:thin:@133.186.171.22:1521:NANET"; 
    static String id = "nanet";
    static String pw = "nanet";

	static Connection conn = null;
	static Statement stmt = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	static ResultSet rs2 = null;
	static ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
	@RequestMapping(value = "/")
	public String main(Locale locale, Model model) {
		
		return "main";
	}
	
	@RequestMapping(value = "/bill.do")
	public String bill(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		gubun = request.getParameter("gubun");
		logtype = request.getParameter("logtype");
		counting = request.getParameter("counting");
		System.out.println("logtype : "+logtype);
		System.out.println("counting :" + counting);
		currentPage = request.getParameter("currentPage");
		rownum = request.getParameter("rownum");
		sorting = request.getParameter("sorting");
		HashMap<String,Object> resultmap = new HashMap<String, Object>();
		DeadLink deadlink = new DeadLink();
		deadlink.setCurrentPage(Integer.parseInt(currentPage));
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession(true);
		List<HashMap<String, Object>> result2 = null;
		List<HashMap<String, Object>> result3 = null;
		
		if(logtype.equals("deadlink")) {
			if(counting.equals("10")) {
				deadlink.setFirstPage((10*deadlink.getCurrentPage())-9);
				deadlink.setLastPage(10*deadlink.getCurrentPage());
			}else if(counting.equals("20")) {
				deadlink.setFirstPage((20*deadlink.getCurrentPage())-19);
				deadlink.setLastPage(20*deadlink.getCurrentPage());
			}else if(counting.equals("30")) {
				deadlink.setFirstPage((30*deadlink.getCurrentPage())-29);
				deadlink.setLastPage(30*deadlink.getCurrentPage());
			}
				
			result2 = sqlSession.selectList("DeadLinkMapper.nr.BillDaedPage", deadlink);
			for (int i = 0; i < result2.size(); i++) {
	   			 resultmap.put("MAINSEQ", result2.get(i).get("MAINSEQ"));
	   			 resultmap.put("URL", result2.get(i).get("URL"));
	   			 resultmap.put("LOG_MSG", result2.get(i).get("LOG_MSG"));
	   			 resultmap.put("ERROR_CODE", result2.get(i).get("ERROR_CODE"));
	   			 resultmap.put("RASMBLY_NM", result2.get(i).get("RASMBLY_NM"));
	   			 resultmap.put("RASMBLY_ID", result2.get(i).get("RASMBLY_ID"));
	   			 list.add(resultmap); 
	   			 resultmap = new HashMap<String, Object>();
	        	}
			
			result3=sqlSession.selectList("DeadLinkMapper.nr.DeadBillCount");
		   	for (int i = 0; i < result3.size(); i++) {
		   		 totalsize = result3.get(i).get("TOTALSIZE").toString();
		   		 model.addAttribute("totalsize", totalsize);
		   	}
		}else if(logtype.equals("errorlog")) {
			if(counting.equals("10")) {
				deadlink.setFirstPage((10*deadlink.getCurrentPage())-9);
				deadlink.setLastPage(10*deadlink.getCurrentPage());
			}else if(counting.equals("20")) {
				deadlink.setFirstPage((20*deadlink.getCurrentPage())-19);
				deadlink.setLastPage(20*deadlink.getCurrentPage());
			}else if(counting.equals("30")) {
				deadlink.setFirstPage((30*deadlink.getCurrentPage())-29);
				deadlink.setLastPage(30*deadlink.getCurrentPage());
			}
			result2 = sqlSession.selectList("DeadLinkMapper.nr.BillErrorPage", deadlink);
			for (int i = 0; i < result2.size(); i++) {
	   			 resultmap.put("MAINSEQ", result2.get(i).get("MAINSEQ"));
	   			 resultmap.put("URL", result2.get(i).get("URL"));
	   			 resultmap.put("LOG_MSG", result2.get(i).get("LOG_MSG"));
	   			 resultmap.put("ERROR_CODE", result2.get(i).get("ERROR_CODE"));
	   			 resultmap.put("RASMBLY_NM", result2.get(i).get("RASMBLY_NM"));
	   			 resultmap.put("RASMBLY_ID", result2.get(i).get("RASMBLY_ID"));
	   			 list.add(resultmap); 
	   			 resultmap = new HashMap<String, Object>();
	        	}
			
			result3=sqlSession.selectList("DeadLinkMapper.nr.ErrorBillCount");
		   	for (int i = 0; i < result3.size(); i++) {
		   		 totalsize = result3.get(i).get("TOTALSIZE").toString();
		   		 model.addAttribute("totalsize", totalsize);
		   	}
		}else if(logtype.equals("recentcollect")) {
			result2 = sqlSession.selectList("DeadLinkMapper.nr.BillRecentPage");
			for (int i = 0; i < result2.size(); i++) {
	   			 resultmap.put("MAINSEQ", result2.get(i).get("MAINSEQ"));
	   			 resultmap.put("RASMBLY_ID", result2.get(i).get("RASMBLY_ID"));
	   			 resultmap.put("ERROR_CODE", result2.get(i).get("COL_CT2"));
	   			 resultmap.put("RASMBLY_NM", result2.get(i).get("RASMBLY_NM"));
	   			 resultmap.put("URL", result2.get(i).get("COL_CT"));
	   			 list.add(resultmap); 
	   			 resultmap = new HashMap<String, Object>();
	        	}
		}
			
			
        try {
			Page page = new Page();
			page.setGubun(gubun);
			page.setLogtype(logtype);
			page.setCounting(counting);
			
			page.setPage(Integer.parseInt(currentPage));
			page.setPageSize(Integer.parseInt(counting));
			page.setIndexSize(10);
			if(logtype.equals("recentcollect")) {
				
			}else {
				page.setTotalRows(Integer.parseInt(totalsize));
			}
			
			model.addAttribute("paging", page.toString());
            model.addAttribute("resultlist",list);
            list = new ArrayList<HashMap<String,Object>>();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		model.addAttribute("gubun", gubun);
		model.addAttribute("logtype", logtype);
		model.addAttribute("counting", counting);
		model.addAttribute("sorting", sorting);
		return "bill";
	}
	
	@RequestMapping(value = "/minutes.do")
	public String minutes(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		gubun = request.getParameter("gubun");
		logtype = request.getParameter("logtype");
		counting = request.getParameter("counting");
		currentPage = request.getParameter("currentPage");
		rownum = request.getParameter("rownum");
		sorting = request.getParameter("sorting");
		HashMap<String,Object> resultmap = new HashMap<String, Object>();
		DeadLink deadlink = new DeadLink();
		deadlink.setCurrentPage(Integer.parseInt(currentPage));
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession(true);
		List<HashMap<String, Object>> result2 = null;
		List<HashMap<String, Object>> result3 = null;
		
		if(logtype.equals("deadlink")) {
			if(counting.equals("10")) {
				deadlink.setFirstPage((10*deadlink.getCurrentPage())-9);
				deadlink.setLastPage(10*deadlink.getCurrentPage());
			}else if(counting.equals("20")) {
				deadlink.setFirstPage((20*deadlink.getCurrentPage())-19);
				deadlink.setLastPage(20*deadlink.getCurrentPage());
			}else if(counting.equals("30")) {
				deadlink.setFirstPage((30*deadlink.getCurrentPage())-29);
				deadlink.setLastPage(30*deadlink.getCurrentPage());
			}
			result2 = sqlSession.selectList("DeadLinkMapper.nr.MinutesDeadPage", deadlink);
			for (int i = 0; i < result2.size(); i++) {
	   			 resultmap.put("MAINSEQ", result2.get(i).get("MAINSEQ"));
	   			 resultmap.put("URL", result2.get(i).get("URL"));
	   			 resultmap.put("LOG_MSG", result2.get(i).get("LOG_MSG"));
	   			 resultmap.put("ERROR_CODE", result2.get(i).get("ERROR_CODE"));
	   			 resultmap.put("RASMBLY_NM", result2.get(i).get("RASMBLY_NM"));
	   			 resultmap.put("RASMBLY_ID", result2.get(i).get("RASMBLY_ID"));
	   			 list.add(resultmap); 
	   			 resultmap = new HashMap<String, Object>();
	        	}
			
			result3=sqlSession.selectList("DeadLinkMapper.nr.DeadMinutesCount");
		   	for (int i = 0; i < result3.size(); i++) {
		   		 totalsize = result3.get(i).get("TOTALSIZE").toString();
		   		 model.addAttribute("totalsize", totalsize);
		   	}
		}else if(logtype.equals("errorlog")) {
			if(counting.equals("10")) {
				deadlink.setFirstPage((10*deadlink.getCurrentPage())-9);
				deadlink.setLastPage(10*deadlink.getCurrentPage());
			}else if(counting.equals("20")) {
				deadlink.setFirstPage((20*deadlink.getCurrentPage())-19);
				deadlink.setLastPage(20*deadlink.getCurrentPage());
			}else if(counting.equals("30")) {
				deadlink.setFirstPage((30*deadlink.getCurrentPage())-29);
				deadlink.setLastPage(30*deadlink.getCurrentPage());
			}
			result2 = sqlSession.selectList("DeadLinkMapper.nr.MinutesErrorPage", deadlink);
			for (int i = 0; i < result2.size(); i++) {
	   			 resultmap.put("MAINSEQ", result2.get(i).get("MAINSEQ"));
	   			 resultmap.put("URL", result2.get(i).get("URL"));
	   			 resultmap.put("LOG_MSG", result2.get(i).get("LOG_MSG"));
	   			 resultmap.put("ERROR_CODE", result2.get(i).get("ERROR_CODE"));
	   			 resultmap.put("RASMBLY_NM", result2.get(i).get("RASMBLY_NM"));
	   			 resultmap.put("RASMBLY_ID", result2.get(i).get("RASMBLY_ID"));
	   			 list.add(resultmap); 
	   			 resultmap = new HashMap<String, Object>();
	        	}
			
			result3=sqlSession.selectList("DeadLinkMapper.nr.ErrorMinutesCount");
		   	for (int i = 0; i < result3.size(); i++) {
		   		 totalsize = result3.get(i).get("TOTALSIZE").toString();
		   		 model.addAttribute("totalsize", totalsize);
		   	}
		}else if(logtype.equals("recentcollect")) {
			result2 = sqlSession.selectList("DeadLinkMapper.nr.MinutesRecentPage");
			for (int i = 0; i < result2.size(); i++) {
	   			 resultmap.put("MAINSEQ", result2.get(i).get("MAINSEQ"));
	   			 resultmap.put("RASMBLY_ID", result2.get(i).get("RASMBLY_ID"));
	   			 resultmap.put("ERROR_CODE", result2.get(i).get("COL_CT2"));
	   			 resultmap.put("RASMBLY_NM", result2.get(i).get("RASMBLY_NM"));
	   			 resultmap.put("URL", result2.get(i).get("COL_CT"));
	   			 list.add(resultmap); 
	   			 resultmap = new HashMap<String, Object>();
	        	}
		}
		
        try {
			Page page = new Page();
			page.setGubun(gubun);
			page.setLogtype(logtype);
			page.setCounting(counting);
			page.setPage(Integer.parseInt(currentPage));
			page.setIndexSize(10);
			page.setPageSize(Integer.parseInt(counting));
			if(logtype.equals("recentcollect")) {
				
			}else {
				page.setTotalRows(Integer.parseInt(totalsize));
			}
			
			model.addAttribute("paging", page.toString());
            model.addAttribute("resultlist",list);
            list = new ArrayList<HashMap<String,Object>>();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		model.addAttribute("gubun", gubun);
		model.addAttribute("logtype", logtype);
		model.addAttribute("counting", counting);
		model.addAttribute("sorting", sorting);
		return "minutes";
	}
	
	@RequestMapping(value = "/pollicy.do")
	public String pollicy(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		gubun = request.getParameter("gubun");
		logtype = request.getParameter("logtype");
		counting = request.getParameter("counting");
		model.addAttribute("gubun", gubun);
		model.addAttribute("logtype", logtype);
		model.addAttribute("counting", counting);
		return "pollicy";
	}
	
}
