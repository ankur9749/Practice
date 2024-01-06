package com.example.serviceImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Comment;

public interface ComentRepository extends JpaRepository<Comment, Long> {

}
