package com.dio.clockIn.repository;

import com.dio.clockIn.model.BankedHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankedHoursRepository extends JpaRepository<BankedHours,Long> {
}
