package com.webbanhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbanhang.entity.PayEntity;

public interface PayRepository extends JpaRepository<PayEntity, Long> {
}
