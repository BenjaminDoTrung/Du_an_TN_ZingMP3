package com.example.du_an_tn_zingmp_3.repository;

import com.example.du_an_tn_zingmp_3.model.Songs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISongRepository extends JpaRepository<Songs,Long> {
    Optional<Songs> findByNameSong(String name);
    Iterable<Songs> findAllByNameSong(String nameSong);
    @Query(value = "select * from songs where name_song like %?%", nativeQuery = true)
    Iterable<Songs> searchByNameSong(String name);
    List<Songs> findAllBySinger (String nameSinger);
    @Query(value = "select * from songs join song_type on song.id_SongTypes = song_type.id where id=?", nativeQuery = true)
    List<Songs> findAllBySongTypes (Long id);

}
