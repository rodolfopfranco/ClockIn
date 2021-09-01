package com.dio.clockIn.repository;

import com.dio.clockIn.model.DateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTypeRepository extends JpaRepository<DateType,Long> {
}
