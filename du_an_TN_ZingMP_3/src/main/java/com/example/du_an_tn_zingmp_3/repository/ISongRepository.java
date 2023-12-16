package com.example.du_an_tn_zingmp_3.repository;

import com.example.du_an_tn_zingmp_3.model.Songs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISongRepository extends JpaRepository<Songs,Long> {
    @Query(value = "select * from songs where name like ?", nativeQuery = true)
    Optional<Songs> findByNameSong(String name);
    @Query(value = "select * from songs where name like %?%", nativeQuery = true)
    Iterable<Songs> findAllByNameSong(String name);
}
