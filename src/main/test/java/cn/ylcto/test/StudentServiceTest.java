
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ylcto.student.service.IStudentService;
import cn.ylcto.student.vo.Classes;
import cn.ylcto.student.vo.Student;

public class StudentServiceTest {
	
	@Resource
	private static IStudentService studentService;
	private static ApplicationContext cxt;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
   cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
   studentService = cxt.getBean("studentServiceImpl",IStudentService.class);
	}

	@Test
	public void testInsert() throws Exception {
		Student vo = new Student();
		Classes classes = new Classes();
		classes.setCid(3);
		vo.setSid("s003");
		vo.setName("学生三");
		vo.setSex(0);
		vo.setAddress("河南省焦作市");
		vo.setAge(25);
		vo.setAddress("河南省焦作市");
		vo.setSex(0);
		vo.setClasses(classes);
		//studentService.insert(vo);
		TestCase.assertTrue(this.studentService.insert(vo));

	}
	
	@Test
	public void testStudentSpilt()throws Exception{
		Map<String, Object> map = this.studentService.listSpilt(1, 3);
	
		System.out.println(map.get("allStudent"));
		System.out.println(map.get("studentCount"));
		TestCase.assertTrue(map.size()==2);
		
	} 
	
	@Test
	public void testUpdate() throws Exception {
		Student vo = new Student();
		vo.setSid("2");
		vo.setName("大燕");
		vo.setAge(11);
		vo.setAddress("河南省焦作市");
		vo.setSex(0);
		Classes classes = new Classes();
		classes.setCid(10);
		vo.setClasses(classes);
		this.studentService.update(vo);
	}
	
	@Test
	public void testDelete() throws Exception{
		List<String> all = new ArrayList<>();
		all.add("2");
		this.studentService.delete(all);
	}
	
}
