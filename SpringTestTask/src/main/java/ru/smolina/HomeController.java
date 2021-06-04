package ru.smolina;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping
	public String showHome(Model model) {
		ImageFile imageFile = new ImageFile();
		imageFile.setName("apple");
		model.addAttribute("imagefile", imageFile);		
		
		String filename = "/images/apple.png";		
		model.addAttribute("filename", filename);
		return "home";
	}
	
	@PostMapping
	public String processHome(@ModelAttribute("imagefile") ImageFile imagefile, Model model) {		
		
		String name = imagefile.getName();
		String filename = "/images/" + name + ".png";
		model.addAttribute("filename", filename);		
		
		return "home";
	}

}
