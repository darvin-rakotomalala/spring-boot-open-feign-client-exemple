package com.poc.service.metier;

import java.util.List;

import com.poc.donnee.dto.PostDTO;

public interface PostSM {

	List<PostDTO> getAllPosts();

	PostDTO getPostById(Long postId);

	List<PostDTO> getAllPostsByUserId(Long userId);

	PostDTO createPost(PostDTO postDTO);

	PostDTO updatePost(Long postId, PostDTO postDTO);

	void deletePost(Long postId);

}
