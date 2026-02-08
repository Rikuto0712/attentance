package com.example.attendance.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.example.attendance.Entity.OvertimeRequest;
import com.example.attendance.repository.OvertimeRepository;

@Service
public class OvertimeService {

	@Autowired
	private OvertimeRepository overtimeRepository;

	public void apply(OvertimeRequest request) {
		request.setStatus("申請中");
		request.setCreatedAt(LocalDateTime.now());
		overtimeRepository.save(request);
	}

	public List<OvertimeRequest> findByUser(User user) {
		return overtimeRepository.findByUser(user);
	}
}
