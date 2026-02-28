package com.academia.restSpringMysqlAlbumes.controller;

import com.academia.restSpringMysqlAlbumes.entity.Album;
import com.academia.restSpringMysqlAlbumes.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/albumes")
class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    public List<Album> listar() {
        return albumService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> buscarPorId(@PathVariable String id) {
        return albumService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Album> crear(@RequestBody Album album) {
        Album creado = albumService.crearAlbum(album);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Album> actualizar(@PathVariable String id,
                                             @RequestBody Album album) {
        return albumService.actualizar(id, album)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        if (albumService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}


