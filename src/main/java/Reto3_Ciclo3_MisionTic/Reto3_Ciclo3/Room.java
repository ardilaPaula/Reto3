/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3_Ciclo3_MisionTic.Reto3_Ciclo3;

/**
 * Import de JsonIgnoreProperties
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Import de Serializable
 */
import java.io.Serializable;
/**
 * Import de List
 */
import java.util.List;
/**
 * Import de CascadeType
 */
import javax.persistence.CascadeType;
/**
 * Import de Entity
 */
import javax.persistence.Entity;
/**
 * Import de GeneratedValue
 */
import javax.persistence.GeneratedValue;
/**
 * Import de GenerationType
 */
import javax.persistence.GenerationType;
/**
 * Import de Id
 */
import javax.persistence.Id;
/**
 * Import de JoinColumn
 */
import javax.persistence.JoinColumn;
/**
 * Import de ManyToOne
 */
import javax.persistence.ManyToOne;
/**
 * Import de OneToMany
 */
import javax.persistence.OneToMany;
/**
 * Impórt de Table
 */
import javax.persistence.Table;

/**
 *
 * @author Paula Ardila
 */
/**
 * Entidad JPA
 */
@Entity
/**
 * Existe una anotacion
 */
@Table(name = "room")
/**
 * Declaracion de clase publica Room
 */
public class Room implements Serializable {

    /**
     * Identificacion del objeto
     */
    @Id
    /**
     * La identificacion debe generarse automaticamente
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Declaracion variable id
     */
    private Integer id;
    /**
     * Declaracion variable name
     */
    private String name;
    /**
     * Declaracion variable stars
     */
    private Integer hotel;
    /**
     * Declaracion variable hotel
     */
    private String stars;
    /**
     * Declaracion variable description
     */
    private String description;

    /**
     * Relacion de muchos a uno
     */
    @ManyToOne
    /**
     * Clave externa que define la relacion
     */
    @JoinColumn(name = "categoryId")
    /**
     * Propiedades que deben ignorarse
     */
    @JsonIgnoreProperties("rooms")
    /**
     * Declaracion variable Category
     */
    private Category category;

    /**
     * Relacion de uno a muchos
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "room")
    /**
     * Propiedades que deben ignorarse
     */
    @JsonIgnoreProperties({"room", "client"})
    /**
     * Declaracion variable message
     */
    private List<Message> messages;

    /**
     * Relacion uno a muchos
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "room")
    /**
     * Propiedades que deben ignorarse
     */
    @JsonIgnoreProperties({"room", "client"})
    /**
     * Declaracion variable Reservation
     */
    private List<Reservation> reservations;

    /**
     * Metodo para mostrar Id
     */
    public Integer getId() {
        return id;
    }

     /**
     * Metodo para modificar Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Metodo para mostrar Name
     */
    public String getName() {
        return name;
    }
   
    /**
     * Metodo para modificar Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo para mostrar Hotel
     */
    public Integer getHotel() {
        return hotel;
    }

    /**
     * Metodo para modificar Hotel
     */
    public void setHotel(Integer hotel) {
        this.hotel = hotel;
    }

    /**
     * Metodo para mostrar Stars
     */
    public String getStars() {
        return stars;
    }
 
    /**
     * Metodo para modificar Stars
     */
    public void setStars(String stars) {
        this.stars = stars;
    }
     
    /**
     * Metodo para mostrar Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Metodo para modificar Description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Metodo para mostrar Category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Metodo para modificar Category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Metodo para mostrar Messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Metodo para modificar Messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Metodo para mostrar Reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Metodo para modificar Reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
