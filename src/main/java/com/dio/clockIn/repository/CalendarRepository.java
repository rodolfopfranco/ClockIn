package com.dio.clockIn.repository;

import com.dio.clockIn.model.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar,Long> {
}
