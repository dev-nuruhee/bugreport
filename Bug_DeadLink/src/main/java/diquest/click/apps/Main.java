package diquest.click.apps;

import java.util.HashMap;
import java.util.List;


import org.apache.ibatis.session.SqlSession;

import diquest.click.apps.MyBatisConnectionFactory;
import diquest.click.apps.DeadLink;

public class Main {
	public static void main(String args[]) {
		DeadLink deadlink = new DeadLink();
		deadlink.setCurrentPage(1);
		deadlink.setFirstPage((10*deadlink.getCurrentPage())-9);
		deadlink.setLastPage(10*deadlink.getCurrentPage());
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession(true);
		
		List<HashMap<String, Object>> result2 = sqlSession.selectList("DeadLinkMapper.nr.BillErrorPage", deadlink);
		
		for (int i = 0; i < result2.size(); i++) { 

			System.out.println(i+1);
			System.out.println(result2.get(i));
			
		}
		 
	}
}
