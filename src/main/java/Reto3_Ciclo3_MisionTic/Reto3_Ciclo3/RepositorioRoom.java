/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3_Ciclo3_MisionTic.Reto3_Ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public class RepositorioRoom {

    @Autowired
    private InterfaceRoom crud;

    public List<Room> getAll() {
        return (List<Room>) crud.findAll();

    }

    public Optional<Room> getRoom(int id) {
        return crud.findById(id);
    }

    public Room save(Room room) {
        return crud.save(room);
    }

    public void delete(Room room) {
        crud.delete(room);
    }
}
