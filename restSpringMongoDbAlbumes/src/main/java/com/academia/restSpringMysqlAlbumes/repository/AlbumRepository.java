package com.academia.restSpringMysqlAlbumes.repository;

import com.academia.restSpringMysqlAlbumes.entity.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumRepository extends MongoRepository<Album, String> {

}
