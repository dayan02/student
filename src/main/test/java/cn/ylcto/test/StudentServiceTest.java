
import java.util.Map;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ylcto.student.service.IStudentService;
import cn.ylcto.student.vo.Classes;
import cn.ylcto.student.vo.Student;

public class StudentServiceTest {
	
	private static IStudentService studentService;
	private static ApplicationContext cxt;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
   cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
   studentService = cxt.getBean("studentServiceImpl",IStudentService.class);
	}

	@Test
	public void test() throws Exception {
		Student vo = new Student();
		Classes classes = new Classes();
		classes.setCid(3);
		vo.setSid("s003");
		vo.setName("学生三");
		vo.setAge(25);
		vo.setAddress("河南省焦作市");
		vo.setSex(0);
		vo.setClasses(classes);
		//studentService.insert(vo);
		TestCase.assertTrue(this.studentService.insert(vo));

	}
	
	@Test
	public void testStudentSpilt()throws Exception{
		Map<String, Object> map = this.studentService.listSpilt(1, 2);
		System.out.println(map.get("allStudent"));
		System.out.println(map.get("studentCount"));
		TestCase.assertTrue(map.size()==2);
	} 
	
	
}
