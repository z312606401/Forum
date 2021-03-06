package Interceptor;

import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import util.PersonUtil;

public class LoginInterceptor implements HandlerInterceptor{

	//执行Handler完成执行此方法  
    //应用场景：统一异常处理，统一日志处理  
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception)
			throws Exception {
	}

	//进入Handler方法之后，返回modelAndView之前执行  
    //应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里  
    //传到视图，也可以在这里统一指定视图 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView exception) throws Exception {
	}

	//执行Handler方法之前执行  
    //用于身份认证、身份授权  
    //比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行 
	//return false表示拦截，不向下执行  
    //return true表示放行 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		boolean needsCheck = false;
		String action=request.getParameter("action");
		if ("initAdd".equals(action)|| "add".equals(action))
			needsCheck = true;
		if (needsCheck && PersonUtil.getPersonInfo(request, response) == null)
			throw new AccountException("您还没有登录");
		return true;
	}

}
