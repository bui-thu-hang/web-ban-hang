package com.webbanhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbanhang.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity findOneByCategoryCode(String code);
}