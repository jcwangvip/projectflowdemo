package com.example.springbootdemo.common.repository;

import com.example.springbootdemo.common.entity.SysActionLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * repository
 *
 * @author jiancheng
 * @date 2019-5-14
 */
public interface SysActionLogRepository extends JpaRepository<SysActionLog, Long> {
}
