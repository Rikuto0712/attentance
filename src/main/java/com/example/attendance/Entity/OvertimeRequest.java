package com.example.attendance.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

import com.example.attendance.User;

@Entity
public class OvertimeRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate overtimeDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private String reason;
	private String status;

	private LocalDateTime createdAt;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	// ===== getter setter =====

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
