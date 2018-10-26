
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ylcto.student.service.IAdminService;
import cn.ylcto.student.vo.Admin;


public class AdminServiceTest {

	 private static ApplicationContext ctx ;
	    private static IAdminService adminService;

	 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	        adminService = ctx.getBean("adminServiceImpl",IAdminService.class);
	}

	
	
	@Test
	public void testLogin() throws Exception {
	 Admin admin = new Admin();
	 admin.setEmail("ylcto@163.com");
	 admin.setPassword("22BB09850349B763292456715CC5E25F");
	Logger logger = LoggerFactory.getLogger(this.getClass());
	logger.info("测试成功");
	 System.out.println(this.adminService.login(admin));
	}
	
	

	
	
	
}
