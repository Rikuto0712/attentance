package com.example.attendance.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.attendance.Entity.LeaveRequest;

@Repository
public interface LeaveRepository
		extends JpaRepository<LeaveRequest, Long> {

	List<LeaveRequest> findByUser(User user);
}
