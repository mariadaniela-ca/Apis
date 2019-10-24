package ar.com.ada.api.inmobiliaria.entities.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ar.com.ada.api.inmobiliaria.entities.inmobiliaria.Inmobiliaria;
import ar.com.ada.api.inmobiliaria.entities.persona.Locatario;

/**
 * Usuario
 */
@Entity
@Table(name = "usuario")

public class Usuario {
    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuarioId;

    private String email;
    
    @OneToOne
    @JoinColumn(name = "locatario_id", referencedColumnName = "locatario_id")
    private Locatario locatario;

    @OneToOne
    @JoinColumn(name = "inmobiliaria_id", referencedColumnName = "inmobiliaria_id")
    private Inmobiliaria inmobiliaria;

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

  

}