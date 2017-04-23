package registrationPonnada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class studentController {
	@Autowired studentDAO dao;
	
	
	@RequestMapping(value = "/form")
	public ModelAndView student( ){
		ModelAndView modelAndView = new ModelAndView( );
		
		modelAndView.setViewName("studentForm");
		modelAndView.addObject("student", new student( ));
		
		return modelAndView;
	}

	@RequestMapping(value = "/result")
	public ModelAndView processUser(student student){
		System.out.println("In processUser");
		ModelAndView modelAndView = new ModelAndView();
		dao.insertStudent(student);
		System.out.println("Value in getName"+ student.getStudentFirstName());
		modelAndView.setViewName("studentResult");
		modelAndView.addObject("s", student);
		return modelAndView;
	}

	@Bean
	public studentDAO dao(){
		studentDAO bean = new studentDAO();
		return bean;
	}	
	
	

	@RequestMapping(value = "/viewAll")
	public ModelAndView viewAll( ){
		ModelAndView modelAndView = new ModelAndView();
		List<student> allStudents = dao.getAllStudents();
		modelAndView.setViewName("viewAllStudents");
		modelAndView.addObject("all", allStudents);
		return modelAndView;
	}
	

}
