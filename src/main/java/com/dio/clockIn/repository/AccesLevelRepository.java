package com.dio.clockIn.repository;

import com.dio.clockIn.model.AccessLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccesLevelRepository extends JpaRepository<AccessLevel, Long> {
}
