package cn.ylcto.util.action;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.ModelAndView;

import cn.ylcto.util.ObjectToJson;

public abstract class DefaultAction {

	
	@Resource
	private MessageSource messageSource;
	
	
	protected HttpServletRequest request=null;
	
	private Integer currentPage = 1; //表单第一页


	private Integer lineSize = 2; //每页记录数
	
	
	public void print(HttpServletResponse response,Object msg) {
		try {
			response.getWriter().print(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void handleList(HttpServletRequest request ,HttpServletResponse response){
		try {
			this.currentPage  = Integer.parseInt(request.getParameter("cp"));
		} catch (Exception e) {
		}
		try {
			this.lineSize = Integer.parseInt(request.getParameter("ls"));
		} catch (Exception e) {
		}
		
		
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public Integer getLineSize() {
		return lineSize;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setLineSize(Integer lineSize) {
		this.lineSize = lineSize;
	}
		
	/**
	 * 根据key读取资源文件的内容
	 * @param key 表示要读取的key 
	 * @param param 表示设置的参数
	 * @return
	 */
	public String getResource(String key,String...param){
		return this.messageSource.getMessage(key,param, Locale.getDefault());
		
	}
	
	
	/**
	 * 根据资源文件读取，设置提示信息与跳转路径
	 * @param mav
	 * @param msg
	 * @param path
	 */
	public void setMsgAndPath(ModelAndView mav,String msg,String path) {
		if(mav!=null){
			if(this.getTest()!=null){
				String[] result = this.getTest().split("\\|");
				mav.addObject("msg", this.messageSource.getMessage(msg, result,Locale.getDefault()));
			}else{
				mav.addObject("msg", this.messageSource.getMessage(msg, null,Locale.getDefault()));
			}
			mav.addObject("path", this.messageSource.getMessage(path, null,Locale.getDefault()));
		}
	}
	
	
	
	/**将对象转换为JSON数据
	 * @param response
	 * @param vo
	 */
	public void printObjectToJson(HttpServletResponse response,Object vo) {


		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().print(ObjectToJson.converterObjectToJson(vo));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**将集合数据转换为JSON
	 * @param response
	 * @param name
	 * @param all
	 */
	public void printListObjectToJson(HttpServletResponse response,String name,List<?> all) {
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().print(ObjectToJson.converterListObjectToJson(name,all));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**将list转换为JSON，并进行分页处理
	 * @param response
	 * @param name
	 * @param all
	 * @param allResources
	 */
	public void printListSpiltObjectToJson(HttpServletResponse response,String name,List<?> all,Integer allResources) {
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().print(ObjectToJson.converterListSpiltObjectToJson(name,all,allResources));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public abstract String getTest();
}





