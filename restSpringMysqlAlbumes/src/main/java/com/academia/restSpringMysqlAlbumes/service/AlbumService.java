package com.academia.restSpringMysqlAlbumes.service;

import com.academia.restSpringMysqlAlbumes.entity.Album;
import com.academia.restSpringMysqlAlbumes.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> listarTodos() {
        return albumRepository.findAll();
    }

    public Optional<Album> buscarPorId(Integer id) {
        return albumRepository.findById(id);
    }

    public Album crearAlbum(Album album) {
        return albumRepository.save(album);
    }

    public Optional<Album> actualizar(Integer id, Album datos) {
        return albumRepository.findById(id).map(album -> {
            album.setArtista(datos.getArtista());
            album.setAnioLanzamiento(datos.getAnioLanzamiento());
            album.setCantidadCanciones(datos.getCantidadCanciones());
            album.setDuracionTotal(datos.getDuracionTotal());
            return albumRepository.save(album);
        });
    }

    public boolean eliminar(Integer id) {
        if(albumRepository.existsById(id)) {
            albumRepository.deleteById(id);
            return true;
        }
        return false;
    }



}
