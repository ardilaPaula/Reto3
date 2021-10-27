/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3_Ciclo3_MisionTic.Reto3_Ciclo3;

/**
 * Import de List
 */
import java.util.List;
/**
 * Import de Optional
 */
import java.util.Optional;
/**
 * Import de Autowired
 */
import org.springframework.beans.factory.annotation.Autowired;
/**
 * Import de Service
 */
import org.springframework.stereotype.Service;

/**
 *
 * @author Paula Ardila
 */

/**
 * Se conecta automaticamente el servicio
 */
@Service
/**
 * Declaracion clase publica de ServiciosReservation
 */
public class ServiciosReservation {
    
    /**
     * Inyecta unas dependencias con otras
     */
    @Autowired
    /**
     * Declaracion variable metodosCrud
     */
    private RepositorioReservation metodosCrud;

    /**
     * Metodo getAll
     * @return 
     */
    public List<Reservation> getAll() {
        return metodosCrud.getAll();
    }

    /**
     * Metodo getReservation
     * @param reservationId
     * @return 
     */
    public Optional<Reservation> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    /**
     * Metodo save
     * @param reservation
     * @return 
     */
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation()==null) {
            return metodosCrud.save(reservation);
        } else {
            Optional<Reservation> evt = metodosCrud.getReservation(reservation.getIdReservation());
            if (evt.isEmpty()) {
                return metodosCrud.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    /**
     * Metodo update
     * @param reservation
     * @return 
     */
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> evt = metodosCrud.getReservation(reservation.getIdReservation());
            if (!evt.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    evt.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    evt.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    evt.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    /**
     * Metodo delete
     * @param reservationId
     * @return 
     */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
