package com.example.du_an_tn_zingmp_3.repository;

import com.example.du_an_tn_zingmp_3.model.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPlayListRepository extends JpaRepository<PlayList, Long> {
    Optional<PlayList> findByNamePlayList(String name);
}
