package com.example.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.attendance.User;
import com.example.attendance.Entity.LeaveRequest;
import com.example.attendance.service.LeaveService;

@Controller
@RequestMapping("/leave")
public class LeaveController {

	@Autowired
	private LeaveService leaveService;

	@GetMapping("/apply")
	public String applyForm(Model model) {
		model.addAttribute("leaveRequest",
				new LeaveRequest());
		return "leave/apply";
	}

	@PostMapping("/apply")
	public String apply(
			@ModelAttribute LeaveRequest request,
			@AuthenticationPrincipal User user) {
		request.setUser(user);
		leaveService.apply(request);
		return "redirect:/dashboard";
	}
}
