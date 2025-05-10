package com.webbanhang.controller.admin;

import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webbanhang.dto.CommentDTO;
import com.webbanhang.service.ICommentService;
import com.webbanhang.service.IProductService;
import com.webbanhang.service.IUserService;
import com.webbanhang.util.MessageUtil;

@Controller(value = "commentControllerOfAdmin")
public class CommentControler {

	@Autowired
	private ICommentService commentService;

	@Autowired
	private IProductService productService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/quan-tri/binh-luan/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, 
								 @RequestParam("limit") int limit, HttpServletRequest request) {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setPage(page);
		commentDTO.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/comment/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		commentDTO.setListResult(commentService.findAll(pageable));
		commentDTO.setTotalItem(commentService.getTotalItem());
		commentDTO.setTotalPage((int) Math.ceil((double) commentDTO.getTotalItem() / commentDTO.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", commentDTO);
		return mav;
	}
	
	
	@RequestMapping(value = "/quan-tri/binh-luan/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/comment/edit");
		CommentDTO commentDTO = new CommentDTO();
		if (id != null) {
			commentDTO = commentService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("products", productService.findAll());
		mav.addObject("users", userService.findAll());
		mav.addObject("model", commentDTO);
		return mav;
		
	}
}

/*package com.webbanhang.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.webbanhang.dto.CommentDTO;
import com.webbanhang.service.ICommentService;
import com.webbanhang.service.IProductService;
import com.webbanhang.service.IUserService;

@RestController
@RequestMapping("/api/admin/comment")  // Đổi sang /api cho đúng chuẩn REST API
public class CommentControler {

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IUserService userService;

    // Trả về danh sách bình luận dưới dạng JSON
    @GetMapping("/list")
    public CommentDTO showList(@RequestParam("page") int page,
                               @RequestParam("limit") int limit) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setPage(page);
        commentDTO.setLimit(limit);
        Pageable pageable = new PageRequest(page - 1, limit);

        List<CommentDTO> commentList = commentService.findAll(pageable);
        commentDTO.setListResult(commentList);
        commentDTO.setTotalItem(commentService.getTotalItem());
        commentDTO.setTotalPage((int) Math.ceil((double) commentDTO.getTotalItem() / commentDTO.getLimit()));
        return commentDTO;
    }

    // Trả về chi tiết bình luận theo id
    @GetMapping("/edit")
    public CommentDTO editNew(@RequestParam(value = "id", required = false) Long id) {
        if (id != null) {
            return commentService.findById(id);
        } else {
            return new CommentDTO(); // Trả về object rỗng nếu không có id
        }
    }
}

*/