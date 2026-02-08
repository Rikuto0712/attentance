package com.example.attendance.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.annotation.Id;

@Entity
public class LeaveRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private User user;

	private LocalDate leaveDate;

	private String leaveType; // 全休 / 午前休 / 午後休

	private String reason;

	private String status;

	private LocalDateTime createdAt;

	// getter setter
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
