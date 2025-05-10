package com.webbanhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbanhang.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long>{

}
