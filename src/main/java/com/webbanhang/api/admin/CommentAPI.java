package com.webbanhang.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbanhang.dto.CommentDTO;
import com.webbanhang.service.ICommentService;

@RestController(value = "commentAPIOfAdmin")
public class CommentAPI {

	@Autowired
	private ICommentService commentService;
	
	@PostMapping("/api/commentAmin")
	public CommentDTO createComment(@RequestBody CommentDTO commentDTO) {
		return commentService.saveAPI(commentDTO);
		
	}
	
	@PutMapping("/api/commentAmin")
	public CommentDTO updateComment(@RequestBody CommentDTO commentDTO) {
		return commentService.saveAPI(commentDTO);
	}
	
	@DeleteMapping("/api/commentAmin")
	public void deleteComment(@RequestBody long[] ids) {
		commentService.delete(ids);
	}
	
}
