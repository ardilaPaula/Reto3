/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3_Ciclo3_MisionTic.Reto3_Ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class ServiciosRoom {

    @Autowired
    private RepositorioRoom metodosCrud;

    public List<Room> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Room> getRoom(int roomId) {
        return metodosCrud.getRoom(roomId);

    }

    public Room save(Room room) {
        if (room.getId() == null) {
            return metodosCrud.save(room);
        } else {
            Optional<Room> evt = metodosCrud.getRoom(room.getId());
            if (evt.isEmpty()) {
                return metodosCrud.save(room);
            } else {
                return room;
            }
        }
    }

    public Room update(Room room) {
        if (room.getId() != null) {
            Optional<Room> evt = metodosCrud.getRoom(room.getId());
            if (!evt.isEmpty()) {
                if (room.getName() != null) {
                    evt.get().setName(room.getName());
                }
                if (room.getHotel() != null) {
                    evt.get().setHotel(room.getHotel());
                }
                if (room.getStars() != null) {
                    evt.get().setStars(room.getStars());
                }
                if (room.getDescription() != null) {
                    evt.get().setDescription(room.getDescription());
                }
                if (room.getCategory() != null) {
                    evt.get().setCategory(room.getCategory());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            } else {
                return room;
            }
        } else {
            return room;
        }
    }

    public boolean deleteRoom(int roomId) {
        Boolean aBoolean = getRoom(roomId).map(room -> {
            metodosCrud.delete(room);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
