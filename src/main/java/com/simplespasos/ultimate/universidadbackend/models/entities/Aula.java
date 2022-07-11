package com.simplespasos.ultimate.universidadbackend.models.entities;

import com.simplespasos.ultimate.universidadbackend.models.entities.Enumeradores.Pizarron;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "aulas")
public class Aula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "numero_aula", nullable = false)
    private Integer numeroAula;
    @Column(name = "medidas_mtsxmts")
    private String medidas;
    @Column(name = "cantidad_pupitres")
    private Integer cantidadPupitres;
    @Column(name = "tipo_pizarron")
    @Enumerated(EnumType.STRING)
    private Pizarron pizarra;
    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;
    @Column(name = "fecha_Modificacion")
    private LocalDateTime fechaModificacion;
    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(
            name = "pabellon_id",
            foreignKey = @ForeignKey(name = "FK_PABELLON_ID")
    )
    private Pabellon pabellon;

    public Aula() {
    }

    public Aula(Integer id, Integer numeroAula, String medidas, Integer cantidadPupitres, Pizarron pizarra) {
        this.id = id;
        this.numeroAula = numeroAula;
        this.medidas = medidas;
        this.cantidadPupitres = cantidadPupitres;
        this.pizarra = pizarra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(Integer numeroAula) {
        this.numeroAula = numeroAula;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public Integer getCantidadPupitres() {
        return cantidadPupitres;
    }

    public void setCantidadPupitres(Integer cantidadPupitres) {
        this.cantidadPupitres = cantidadPupitres;
    }

    public Pizarron getPizarra() {
        return pizarra;
    }

    public void setPizarra(Pizarron pizarra) {
        this.pizarra = pizarra;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Pabellon getPabellon() {
        return pabellon;
    }

    public void setPabellon(Pabellon pabellon) {
        this.pabellon = pabellon;
    }

    @PrePersist
    public void antesPersitir(){
        this.fechaAlta = LocalDateTime.now();
    }

    @PreUpdate
    public void antesUpdate(){
        this.fechaModificacion = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Aula{" +
                "id=" + id +
                ", numeroAula=" + numeroAula +
                ", medidas='" + medidas + '\'' +
                ", cantidadPupitres=" + cantidadPupitres +
                ", pizarra=" + pizarra +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aula aula = (Aula) o;
        return id.equals(aula.id) && numeroAula.equals(aula.numeroAula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroAula);
    }
}

