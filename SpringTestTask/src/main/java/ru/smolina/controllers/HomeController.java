package ru.smolina.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.smolina.domain.ImageFile;
import ru.smolina.domain.ImageSource;

@Controller
@RequestMapping("/")
public class HomeController {

	private ImageSource imgSource = new ImageSource();
	String defaultName = "lemon";

	@GetMapping
	public String showHome(Model model) {	
		
		ImageFile imageFile = new ImageFile();
		imageFile.setName(defaultName); 
		model.addAttribute("imagefile", imageFile);
		
		String img = imgSource.getImageFromVash(defaultName);
		model.addAttribute("image", img);

		return "home";
	}

	@PostMapping
	public String processHome(@ModelAttribute("imagefile") ImageFile imagefile, Model model) {

		String name = imagefile.getName();
	
		model.addAttribute("image", imgSource.getImageFromVash(name));
		return "home";
	}
}
