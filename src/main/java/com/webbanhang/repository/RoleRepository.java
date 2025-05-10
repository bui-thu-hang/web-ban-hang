package com.webbanhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbanhang.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	RoleEntity findOneByRoleCode(String code);
}
