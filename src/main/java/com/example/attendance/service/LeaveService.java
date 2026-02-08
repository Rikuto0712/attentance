package com.example.attendance.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendance.Entity.LeaveRequest;
import com.example.attendance.repository.LeaveRepository;

@Service
public class LeaveService {

	@Autowired
	private LeaveRepository leaveRepository;

	public void apply(LeaveRequest request) {
		request.setStatus("申請中");
		request.setCreatedAt(LocalDateTime.now());
		leaveRepository.save(request);
	}
}
