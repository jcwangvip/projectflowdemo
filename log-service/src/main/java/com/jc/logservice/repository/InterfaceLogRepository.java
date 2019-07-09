package com.jc.logservice.repository;

import com.jc.logservice.entity.InterfaceLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfaceLogRepository extends JpaRepository<InterfaceLogEntity, Long> {

}
