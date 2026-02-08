package com.example.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.attendance.Entity.OvertimeRequest;
import com.example.attendance.repository.UserRepository;
import com.example.attendance.service.OvertimeService;

@Controller
@RequestMapping("/overtime")
public class OvertimeController {

	@Autowired
	private OvertimeService overtimeService;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/apply")
	public String applyForm(Model model) {
		model.addAttribute("overtimeRequest",
				new OvertimeRequest());
		return "overtime/apply";
	}

	@PostMapping("/apply")
	public String apply(
			@ModelAttribute OvertimeRequest request,
			@AuthenticationPrincipal UserDetails userDetails) {

		com.example.attendance.User currentUser = userRepository.findByUsername(userDetails.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found"));

		request.setUser(currentUser);
		overtimeService.apply(request);
		return "redirect:/dashboard";
	}

}
