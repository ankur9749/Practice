package com.example.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.grammars.hql.HqlParser.SortDirectionContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.dto.PostDto;
import com.example.entity.Aentity;
import com.example.exceptions.ResourceNotFoundException;
import com.example.repositry.PostRepository;
import com.example.service.PostService;

import jakarta.persistence.Entity;

@Service
public class PostServiceImpl implements PostService {

	private PostRepository postRepo;

	public PostServiceImpl(PostRepository postRepo) {
		this.postRepo = postRepo;
	}

	@Override
	public PostDto createPost(PostDto postDto) {

		// before saving the data

		Aentity entity = new Aentity();
		entity.setTitle(postDto.getTitle());
		entity.setContent(postDto.getContent());
		entity.setDescription(postDto.getDescription());

		Aentity save = postRepo.save(entity);

		// after saving the data

		PostDto dto = new PostDto();

		dto.setId(save.getId());
		dto.setTitle(save.getTitle());
		dto.setContent(save.getContent());
		dto.setDescription(save.getDescription());
		dto.setMessage("post is created");

		return dto;
	}

	@Override
	public void deletePost(int id) {
		postRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("post not found with id: " + id));
		postRepo.deleteById(id);
	}

	@Override
	public List<PostDto> getAllPost(int pageNo, int pageSize, String sortBy, String sortOrder) {
		Sort sort = sortOrder.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortOrder).ascending() : Sort.by(sortBy).descending();
		Pageable of = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Aentity> findAll = postRepo.findAll(of);
		List<Aentity> cont = findAll.getContent();
		List<PostDto> collect = cont.stream().map(p->mapToDto(p)).collect(Collectors.toList());
		return collect;
	}

	PostDto mapToDto(Aentity ent) {
		PostDto dto = new PostDto();

		dto.setId(ent.getId());
		dto.setTitle(ent.getTitle());
		dto.setContent(ent.getContent());
		dto.setDescription(ent.getDescription());
		return dto;
	}

	public PostDto updatePost(int id, PostDto postDto) {
		Aentity or = postRepo.findById(id).orElseThrow(()-> 
			new ResourceNotFoundException("Post not found Id: "+id));
		or.setTitle(postDto.getTitle());
		or.setContent(postDto.getContent());
		or.setDescription(postDto.getDescription());
		
		Aentity save = postRepo.save(or);
		
		PostDto dto = mapToDto(save);
		return dto;
	}

}
