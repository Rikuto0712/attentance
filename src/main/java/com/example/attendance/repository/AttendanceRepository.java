package com.example.attendance.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.attendance.Attendance;
import com.example.attendance.User;

@Repository
// このインタフェースがリポジトリ層のコンポーネントであることを示すアノテーション。
// Spring が自動的にインスタンス化して DI 対象にしてくれる。
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
	// Attendance エンティティのデータアクセスを担当するインタフェース。
	// JpaRepository を継承することで基本的な CRUD 操作が全て利用可能になる。
	// 第 1 引数はエンティティの型、第 2 引数は主キーの型。
	List<Attendance> findByUserOrderByRecordDateDesc(User user);

	// 指定した User に紐づく勤怠レコードを取得するメソッド。
	// 日付の降順で返す。
	Optional<Attendance> findByUserAndRecordDate(User user, LocalDate recordDate);

	// 指定した User かつ特定の日付の勤怠レコードを取得するメソッド。
	List<Attendance> findByUserId(Long userId);

	// 指定したユーザーID に紐づく勤怠レコードを取得するメソッド。
	List<Attendance> findByRecordDateBetween(LocalDate startDate, LocalDate endDate);

	// 指定した日付範囲内の勤怠レコードを取得するメソッド。
	List<Attendance> findByUserIdAndRecordDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
	// 指定したユーザーID かつ日付範囲内の勤怠レコードを取得するメソッド。
}