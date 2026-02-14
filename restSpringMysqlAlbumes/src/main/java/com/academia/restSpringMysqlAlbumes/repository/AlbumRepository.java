package com.academia.restSpringMysqlAlbumes.repository;

import com.academia.restSpringMysqlAlbumes.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album,Integer> {

}
