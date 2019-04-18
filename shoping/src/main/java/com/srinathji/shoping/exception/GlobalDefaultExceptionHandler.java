package com.srinathji.shoping.exception;



import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView noHandlerFoundException(){
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTittel", "the page is not Constracated");
		mv.addObject("errorDescreption", "the page You are lloking for is not avalable now!");
		mv.addObject("tittel", "404 error");


		return mv;
	}
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView productNotFoundException(){
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTittel", "Product not avalable");
		mv.addObject("errorDescreption", "the produc You are lloking for is not avalable right now!");
		mv.addObject("tittel", "product anvalable");


		return mv;
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception ex){
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTittel", "Contact your administrator !");
		mv.addObject("errorDescreption", ex.toString());
		mv.addObject("tittel", "error");
		ex.printStackTrace();

		return mv;
	}
}
