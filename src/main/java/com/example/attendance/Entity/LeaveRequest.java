package com.example.attendance.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LeaveRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// 例：有給の項目（あなたの設計に合わせてOK）
	private LocalDate startDate;
	private LocalDate endDate;
	private String leaveType;
	private String reason;

	private String status;
	private LocalDateTime createdAt;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private com.example.attendance.User user;

	// --- getter/setter（最低限） ---
	public Long getId() {
		return id;
	}

	public com.example.attendance.User getUser() {
		return user;
	}

	public void setUser(com.example.attendance.User user) {
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
