package com.webbanhang.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbanhang.dto.CommentDTO;
import com.webbanhang.service.ICommentService;
import com.webbanhang.util.SecurityUtils;

@RestController(value = "commentAPIOfWeb")
public class CommentAPI {
	
	@Autowired
	private ICommentService commentService;
	
	@PostMapping("/api/comment")
	public CommentDTO createComment(@RequestBody CommentDTO commentDTO) {		
//		commentDTO.setUserId(SecurityUtils.getPrincipal().getId());
		return commentService.save(commentDTO);
	}
	
//	@PutMapping("/api/comment")
//	public CommentDTO updateComment(@RequestBody CommentDTO commentDTO) {		
//		return commentService.save(commentDTO);
//	}
	
//	@DeleteMapping("/api/comment")
//	public void deleteComment(@RequestBody long[] ids) {
//		commentService.delete(ids);
//	}

}
