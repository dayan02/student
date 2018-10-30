package cn.ylcto.util.interceptor;

import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.MessageSource;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.ylcto.util.tools.Validator;


public class ValidatorInterceptor implements HandlerInterceptor{
	 @Resource
	    private MessageSource messageSource;
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		 HandlerMethod handlerMethod = (HandlerMethod) handler;
//       System.out.println("对象："+handlerMethod.getBean().getClass().getSimpleName());
//       System.out.println("方法："+handlerMethod.getMethod().getName());
       try {
           String vkey = handlerMethod.getBean().getClass().getSimpleName() + "." + handlerMethod.getMethod().getName();
           String pkey = handlerMethod.getBean().getClass().getSimpleName() + "." + handlerMethod.getMethod().getName() + ".error";
           String validatorValue = this.messageSource.getMessage(vkey, null, Locale.getDefault());
           String pagesValue = this.messageSource.getMessage(pkey, null, Locale.getDefault());
           if (validatorValue != null) {
               if (new Validator().validate(request, validatorValue)) {
                   return true;
               } else {
            	   request.getRequestDispatcher(pagesValue).forward(request, response);
                   return false;
               }
           }
       }catch (Exception e){}
       return true;
   }

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
