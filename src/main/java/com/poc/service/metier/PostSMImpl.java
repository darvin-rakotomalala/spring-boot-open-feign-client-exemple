package com.poc.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.donnee.dto.PostDTO;
import com.poc.service.businessdelegate.PostFeignClient;

@Service
public class PostSMImpl implements PostSM {

	@Autowired
	private PostFeignClient postFeignClient;
	
	@Override
	public List<PostDTO> getAllPosts() {
		return postFeignClient.getAllPosts();
	}

	@Override
	public PostDTO getPostById(Long postId) {
		return postFeignClient.getPostById(postId);
	}

	@Override
	public List<PostDTO> getAllPostsByUserId(Long userId) {
		return postFeignClient.getPostByUserId(userId);
	}

	@Override
	public PostDTO createPost(PostDTO postDTO) {
		return postFeignClient.createPost(postDTO);
	}

	@Override
	public PostDTO updatePost(Long postId, PostDTO postDTO) {
		return postFeignClient.updatePost(postDTO);
		
	}

	@Override
	public void deletePost(Long postId) {
		postFeignClient.deletePost(postId);
		
	}

}
