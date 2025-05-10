package com.webbanhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbanhang.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	ProductEntity findOneByProductCode(String code);
}
