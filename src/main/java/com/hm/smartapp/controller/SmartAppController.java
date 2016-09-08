package com.journaldev.spring;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.journaldev.spring.model.Sortinfo;
import com.journaldev.spring.model.Sortnumber;
import com.journaldev.spring.smart.service.SmartService;

@Controller
public class NumberController {
	
	private static final Logger logger = LoggerFactory.getLogger(NumberController.class);
	
	private SmartService samrtService;
	
	@Autowired(required=true)
	@Qualifier(value="SmartService")
	public void setSmartService(SmartService smartService){
		this.samrtService = smartService;
	}
	
	@RequestMapping(value = "/view/pastsorts", method = RequestMethod.GET)
	public String listPastSorts(Model model) throws Exception {
		model.addAttribute("sortInfo", new Sortinfo());
		model.addAttribute("sortList", this.samrtService.listPastSorts());
		return "history";
	}
	
	
	//For add and update person both
	@RequestMapping(value= "/numbers/generate", method = RequestMethod.POST)
	public String generateSorts(@ModelAttribute("Sortinfo") Sortinfo sortInfo){
			sortInfo= samrtService.createAndSaveSortInfo(sortInfo.getSizeOfNumbers());
			
			return "redirect:/view/pastsorts";
			
		}
	//For add and update person both
	@RequestMapping(value= "/view/numbers/{id}", method = RequestMethod.GET)
		public String viewNumbers(@PathVariable("id") int id , Model model){
		List<Sortnumber> sortNumbers= samrtService.retriveSortNumbers(id);
		model.addAttribute("sortNumbers",sortNumbers);
		
		return "viewnumbers";
				
		}
	
	 
	/**
	 * This method will capture generic exception and show consistent error page to the user. 
	 * @param  exception
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception exception) {
		ModelAndView model = new ModelAndView("error");
		logger.error("Un expected error. Please try after sometime" + exception.getMessage());
		model.addObject("errMsg", "Un expected error. Please try after sometime " );
		return model;
	}
	
	
	
	

	
}
