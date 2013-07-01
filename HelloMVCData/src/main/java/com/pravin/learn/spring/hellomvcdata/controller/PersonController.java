package com.pravin.learn.spring.hellomvcdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.pravin.learn.spring.hellomvcdata.model.Person;
import com.pravin.learn.spring.hellomvcdata.service.PersonService;

@Controller   
@SessionAttributes(value = {"searchList", "searchStatus"})
public class PersonController {  

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String getPersonList(ModelMap model) {
		System.out.println("In /person");
		if (null != model && (null == model.get("searchStatus") || false == (Boolean) model.get("searchStatus"))) {
			model.addAttribute("personList", personService.listPerson());  
			System.out.println("called listPerson()" + model.get("searchStatus"));
		} else {
			model.addAttribute("personList", model.get("searchList"));
			System.out.println("got searchList");
			
		}
		model.addAttribute("searchStatus", false);  
		
		return "Person";  
	}  

	@RequestMapping(value = "/person/search", method = RequestMethod.POST)  
	public View searchPerson(@ModelAttribute Person person, ModelMap model) {
		model.addAttribute("searchList", personService.searchPerson(person.getName()));  
		model.addAttribute("searchStatus", true);  
		return new RedirectView("/HelloMVCData/person");  
	}

	@RequestMapping(value = "/person/save", method = RequestMethod.POST)  
	public View createPerson(@ModelAttribute Person person, ModelMap model) {
		if(StringUtils.hasText(person.getId())) {
			personService.updatePerson(person);
		} else {
			personService.addPerson(person);
		}
		return new RedirectView("/HelloMVCData/person");  
	}

	@RequestMapping(value = "/person/delete", method = RequestMethod.GET)  
	public View deletePerson(@ModelAttribute Person person, ModelMap model) {  
		personService.deletePerson(person);  
		return new RedirectView("/HelloMVCData/person");  
	}    
}