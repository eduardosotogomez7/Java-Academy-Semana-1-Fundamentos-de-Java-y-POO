package com.academia.restSpringMysqlAlbumes.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "albumes")
public class Album {

    @Id
    private String id;


    private String artista;


    private Integer anioLanzamiento;


    private Integer cantidadCanciones;


    private Integer duracionTotal;

    public Album() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Integer getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(Integer anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public Integer getCantidadCanciones() {
        return cantidadCanciones;
    }

    public void setCantidadCanciones(Integer cantidadCanciones) {
        this.cantidadCanciones = cantidadCanciones;
    }

    public Integer getDuracionTotal() {
        return duracionTotal;
    }

    public void setDuracionTotal(Integer duracionTotal) {
        this.duracionTotal = duracionTotal;
    }
}
