package mx.utng.ultima.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Television {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String fecha;

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String horasVistas;


    //GETTERS Y SETTERS
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getHorasVistas() {
        return horasVistas;
    }
    public void setHorasVistas(String horasVistas) {
        this.horasVistas = horasVistas;
    }
}

