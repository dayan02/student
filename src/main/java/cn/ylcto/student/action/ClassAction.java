package cn.ylcto.student.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.ylcto.student.service.IClassesService;
import cn.ylcto.student.vo.Classes;
import cn.ylcto.util.action.DefaultAction;

@Controller
@RequestMapping(value="/pages/back/classes/*")
public class ClassAction extends DefaultAction{

	@Resource
	private IClassesService classesService;
	/*使用jstl显示数据信息
	@RequestMapping(value="classes_list")
	public void list() {
		try {
			super.request.setAttribute("list",this.classesService.list());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/

	
	@RequestMapping(value="classes_list")
	public void list(HttpServletResponse response) {
		
		try {
			super.printListObjectToJson(response, "allClasses", this.classesService.list());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping(value="classes_insert")
	public ModelAndView insert(Classes classes) {
		
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward", "/pages/forward.jsp"));
		try {
			if (classesService.insert(classes)) {
				super.setMsgAndPath(mav, "classes.insert.success", "classes.login.success");
			}else{
				super.setMsgAndPath(mav, "classes.insert.failure", "classes.login.failure");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;
		
	}
	
	
	@Override
	public String getTest() {
		// TODO Auto-generated method stub
		return "班级";
	}

}
