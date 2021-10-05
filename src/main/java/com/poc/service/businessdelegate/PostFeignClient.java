package com.poc.service.businessdelegate;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poc.config.FeignClientConfig;
import com.poc.donnee.dto.PostDTO;

@FeignClient(name = "postFeignClient", configuration = FeignClientConfig.class, url = "${client.post.baseUrl}")
public interface PostFeignClient {

	@GetMapping("/posts")
	List<PostDTO> getAllPosts();

	@GetMapping("/posts/{postId}")
	PostDTO getPostById(@PathVariable Long postId);

	@GetMapping("/posts")
	List<PostDTO> getPostByUserId(@RequestParam Long userId);

	@PostMapping("/posts")
	PostDTO createPost(PostDTO postDTO);

	@PutMapping("/posts")
	PostDTO updatePost(PostDTO postDTO);

	@DeleteMapping("/posts/{postId}")
	PostDTO deletePost(@PathVariable Long postId);
}
