package com.academia.restSpringMysqlAlbumes.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "albumes")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String artista;

    @Column(name = "anio_lanzamiento", nullable = false)
    private Integer anioLanzamiento;

    @Column(name = "cantidad_canciones", nullable = false)
    private Integer cantidadCanciones;

    @Column(name = "duracion_total", nullable = false)
    private Integer duracionTotal;

    public Album() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
