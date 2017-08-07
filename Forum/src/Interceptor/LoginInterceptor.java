package Interceptor;

import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import util.PersonUtil;

public class LoginInterceptor implements HandlerInterceptor{

	//ִ��Handler���ִ�д˷���  
    //Ӧ�ó�����ͳһ�쳣����ͳһ��־����  
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception)
			throws Exception {
	}

	//����Handler����֮�󣬷���modelAndView֮ǰִ��  
    //Ӧ�ó�����modelAndView�����������õ�ģ������(����˵�����)������  
    //������ͼ��Ҳ����������ͳһָ����ͼ 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView exception) throws Exception {
	}

	//ִ��Handler����֮ǰִ��  
    //���������֤�������Ȩ  
    //���������֤�������֤ͨ����ʾ��ǰ�û�û�е�½����Ҫ�˷������ز�������ִ�� 
	//return false��ʾ���أ�������ִ��  
    //return true��ʾ���� 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		boolean needsCheck = false;
		String action=request.getParameter("action");
		if ("initAdd".equals(action)|| "add".equals(action))
			needsCheck = true;
		if (needsCheck && PersonUtil.getPersonInfo(request, response) == null)
			throw new AccountException("����û�е�¼");
		return true;
	}

}
