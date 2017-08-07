package Controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("category_list.do")
	public ModelAndView list(HttpServletRequest request){
		request.setAttribute("title", "轻量级 Java EE 论坛程序");
		List<Category> categoryList = categoryService.getList();
		request.setAttribute("categoryList", categoryList);
		return new ModelAndView("category/listCategory");
	}
	
	@RequestMapping("category_initAdd.do")
	public ModelAndView initAdd(HttpServletRequest request){
		request.setAttribute("title", "添加类别");
		request.setAttribute("category", new Category());
		return new ModelAndView("category/addCategory");
	}
	
	@RequestMapping("category_add.do")
	public ModelAndView add(@ModelAttribute Category category, HttpServletRequest request){
		request.setAttribute("title", "添加类别");
		category.setDatecreated(new Date());
		category.setDeleted(false);
		categoryService.create(category);
		return new ModelAndView("category/success");
	}

}
