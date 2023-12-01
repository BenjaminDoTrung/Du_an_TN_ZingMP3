package com.example.du_an_tn_zingmp_3.repository;

import com.example.du_an_tn_zingmp_3.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository<Comments, Long> {
}
