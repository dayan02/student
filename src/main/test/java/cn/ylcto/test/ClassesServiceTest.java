import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ylcto.student.service.IClassesService;
import cn.ylcto.student.vo.Classes;


public class ClassesServiceTest {

	private static ApplicationContext ctx;
	private static IClassesService classesService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		classesService = ctx.getBean("classesServiceImpl",IClassesService.class);
	}

	@Test
	public void test() {
		Classes classes = new Classes();
		classes.setCname("Coo3");
		classes.setNote("这是三班的班级介绍");
		try {
			
			//使用断言检查条件为真
			TestCase.assertTrue(classesService.insert(classes));
			
			/*
			if(classesService.insert(classes)){
					return;
			}
			*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void test1() throws Exception{
		System.out.println(this.classesService.list());
	}
}
