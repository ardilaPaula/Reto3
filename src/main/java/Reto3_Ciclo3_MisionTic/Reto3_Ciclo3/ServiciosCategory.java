package Reto3_Ciclo3_MisionTic.Reto3_Ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author usuario
 */
@Service
public class ServiciosCategory {

    @Autowired
    private RepositorioCategory metodosCrud;

    public List<Category> getAll() {
        return metodosCrud.getAll();

    }

    public Optional<Category> getCategory(int CategoryId) {
        return metodosCrud.getCategory(CategoryId);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return metodosCrud.save(category);
        } else {
            Optional<Category> categorial = metodosCrud.getCategory(category.getId());
            if (categorial.isEmpty()) {
                return metodosCrud.save(category);
            } else {
                return category;
            }
        }
    }

    public Category update(Category category) {
        if (category.getId() != null) {
            Optional<Category> gta = metodosCrud.getCategory(category.getId());
            if (!gta.isEmpty()) {
                if (category.getDescription() != null) {
                    gta.get().setDescription(category.getDescription());
                }
                if (category.getName() != null) {
                    gta.get().setName(category.getName());
                }
                return metodosCrud.save(gta.get());
            }
        }
        return category;
    }
    public boolean deletecategory(int categoryId){
        Boolean def=getCategory(categoryId).map(category -> {
            metodosCrud.delete(category);
            return true;
        }).orElse(false);
        return def;
    }
    
}
