package com.poc.infrastructure;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.poc.donnee.dto.PostDTO;
import com.poc.service.metier.PostSM;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostSM postSM;

	@Operation(summary = "find all posts")
	@GetMapping
	public List<PostDTO> getAllPosts() {
		return postSM.getAllPosts();
	}

	@Operation(summary = "find post by Id")
	@GetMapping("/{postId}")
	public PostDTO getPostById(@PathVariable Long postId) {
		return postSM.getPostById(postId);
	}

	@Operation(summary = "find all posts by userId")
	@GetMapping("/userId/{userId}")
	public PostDTO getAllPostsByUserId(@PathVariable Long userId) {
		return postSM.getPostById(userId);
	}

	@Operation(summary = "add post")
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public PostDTO createPost(PostDTO postDTO) {
		return postSM.createPost(postDTO);
	}

	@Operation(summary = "update post by Id")
	@PutMapping("/update/{postId}")
	@ResponseStatus(HttpStatus.OK)
	public PostDTO updatePost(@PathVariable Long postId, PostDTO postDTO) {
		return postSM.updatePost(postId, postDTO);
	}

	@Operation(summary = "delete post by Id")
	@DeleteMapping("/delete/{postId}")
	@ResponseStatus(HttpStatus.OK)
	public void deletePost(@PathVariable Long postId) {
		postSM.deletePost(postId);
	}

}
