package exception;

import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


public class ForumExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception) {
		request.setAttribute("message", exception.getMessage());
		request.setAttribute("person", new Person());
		if (exception instanceof AccountException) 
			return new ModelAndView("person/login");
		return new ModelAndView("exception");
	}


}
