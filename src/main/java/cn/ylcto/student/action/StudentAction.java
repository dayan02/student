package cn.ylcto.student.action;

import java.util.List;
import java.util.Map;

import cn.ylcto.student.service.IStudentService;
import cn.ylcto.student.vo.Student;
import cn.ylcto.util.action.DefaultAction;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping(value = "/pages/back/student/*")
public class StudentAction extends DefaultAction {
    @Resource
    private IStudentService  studentService;

    @RequestMapping (value = "student_insert")
    public ModelAndView insert(Student vo){
        ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
        try {
            if (this.studentService.insert(vo)){ // 表示数据增加成功
                super.setMsgAndPath(mav,"student.insert.success","student.login.success");
            }else{  // 表示数据增加失败
                super.setMsgAndPath(mav,"student.insert.failure","student.login.failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @RequestMapping(value = "student_list")
    public void list(HttpServletRequest request, HttpServletResponse response){
        super.handleList(request, response);
        try {
            Map<String,Object> map = this.studentService.listSpilt(super.getCurrentPage(),super.getLineSize());
            List<Student> all = (List<Student>) map.get("allStudent");
            Integer allRecorders = (Integer) map.get("studentCount");
            super.printListSpiltObjectToJson(response,"allStudent",all,allRecorders);
        } catch (Exception e) {
            e.printStackTrace();
        }
	
}
    
    @RequestMapping(value="student_update")
    public void update(HttpServletResponse response,Student vo) {
		try {
			super.print(response, this.studentService.update(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	@Override
	public String getTest() {
		// TODO Auto-generated method stub
		return "学生";
	}

	
}
