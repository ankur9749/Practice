package com.example.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Aentity;

public interface PostRepository extends JpaRepository<Aentity, Integer>{

	//void findById(int postId);

}
