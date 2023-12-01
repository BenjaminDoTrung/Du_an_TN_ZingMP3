package com.example.du_an_tn_zingmp_3.repository;

import com.example.du_an_tn_zingmp_3.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikeRepository extends JpaRepository<Likes, Long> {
}
