package com.InfoInput.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.InfoInput.model.person;
import com.InfoInput.repository.PersonRepository;

@Controller
public class PersonController {
	@Autowired
	PersonRepository personRepository;
	//----Register----
	@GetMapping("/person/new")
	public String registerInterface(Model model) {
		model.addAttribute("person", new person());
		return "newPerson";
	}
	@PostMapping("/person/new")
	public String registerPerson(@Valid person person, BindingResult bindingResult)
	{
		if(bindingResult.hasFieldErrors()) {
			return "newPerson";
		}
		personRepository.save(person);
		return "redirect:/person/list";
	}
	//----List----
	@GetMapping("/person/list")
	public String showAllPeople(Map<String, Object> model) {
		List<person> person = personRepository.findAll();
		model.put("person", person);
		return "allPeople";
	}
	//----Delete----
	@GetMapping("/person/{personId}/delete")
	public String deletePerson(@PathVariable("personId") Integer id, Model model){
		person person = personRepository.findById(id);
		personRepository.delete(person);
		return "redirect:/person/list";
	}
	//----Update----
	@GetMapping("/person/{personId}/update")
	public String updatePerson(@PathVariable("personId") Integer id, Model model){
		person person = personRepository.findById(id);
		model.addAttribute("person", person);
		return "updatePerson";
	}
	@PostMapping("/person/{personId}/update")
	public String applyUpdate(@PathVariable("personId") Integer id,@Valid person person ,BindingResult bindingResult) {
		if(bindingResult.hasFieldErrors()) {
			return "redirect:/person/{personId}/update}";
		}
		person.setId(id);
		personRepository.save(person);
		return "redirect:/person/list";
	}
}
