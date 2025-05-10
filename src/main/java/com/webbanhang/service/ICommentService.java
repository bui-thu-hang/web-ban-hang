package com.webbanhang.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.webbanhang.dto.CommentDTO;

public interface ICommentService {	
	List<CommentDTO> findAllByProductId(Long productId);
	CommentDTO save(CommentDTO dto);
	void delete(long[] ids);
//	ad
	List<CommentDTO> findAll(Pageable pageable);
	int getTotalItem();
	CommentDTO findById(long id);
	CommentDTO saveAPI(CommentDTO dto);

}
