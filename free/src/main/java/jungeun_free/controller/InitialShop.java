package jungeun_free.controller;

import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class InitialShop
 *
 */
@WebListener
public class InitialShop implements ServletContextListener {


	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	ServletContext context = sce.getServletContext();
    	ArrayList<Local> datas = new ArrayList<Local>();
    	
    	for(int i=0;i<8;i++) {
    		Local data = new Local("포인트"+i,"상호명"+i);
    		datas.add(data);
    	}
    	
    	datas.add(new Local("제주도","다이브"));
    	datas.add(new Local("울릉도","다이브"));
    	
    	context.setAttribute("locals", datas);
    	context.setAttribute("local", new Local());
    }
	
}
