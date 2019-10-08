package ar.com.ada.api.billeteravirtual.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import ar.com.ada.api.billeteravirtual.security.Crypto;

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

    private String username;

    private String password;

    private String email;

    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "persona_id")
    private Persona persona;

    // public Cuenta cuenta;

    public Usuario() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = Crypto.encrypt(password, this.getUsername());
        
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String toString() {
        return "Usuario [User Name=" + username + ", Password=" + password + ", User Email=" + email + "]";
    }

    /*
     * public void setPersonaid(int personaid) { this.personaid = personaid;
     * 
     * }
     * 
     * public int getPersonaid() { return personaid; }
     * 
     * public int getPersonaId() { return personaId; }
     * 
     * public void setPersonaId(int personaId) { this.personaId = personaId; }
     * 
     * public Usuario(int personaId) { this.personaId = personaId; }
     */

     public void setPersonaId(int personaId){
        personaId = persona.getPersonaId();
     }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }


}