package cn.ylcto.student.action;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.ylcto.student.service.IAdminService;
import cn.ylcto.student.vo.Admin;
import cn.ylcto.util.MD5Code;
import cn.ylcto.util.action.DefaultAction;



@RequestMapping(value="/pages/back/*")
@Controller
public class AdminLoginAction extends DefaultAction{

	@Resource
	private IAdminService adminService;
	

	@RequestMapping(value="/admin_login")
	public ModelAndView login(HttpServletRequest request,Admin admin) {
		
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		
		try {
			
			//实现登录密码加盐操作
			admin.setPassword(new MD5Code().getMD5ofStr(admin.getPassword()+admin.getEmail()));
			Admin vo = this.adminService.login(admin);
			
			if(vo!=null){
				super.setMsgAndPath(mav, "admin.insert.success", "admin.login.success");
				request.getSession().setAttribute("email", vo.getEmail());
				request.getSession().setAttribute("lastdate", new SimpleDateFormat("yyyy-MM-dd").format(vo.getLastdate()));
	}else{
				super.setMsgAndPath(mav, "admin.insert.failure", "admin.login.failure");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mav;
	}

	@Override
	public String getTest() {
		
		return "管理员";
	}
	
	
}
