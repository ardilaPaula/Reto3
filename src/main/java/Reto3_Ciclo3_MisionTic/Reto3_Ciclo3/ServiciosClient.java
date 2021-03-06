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
public class ServiciosClient {
    @Autowired
    private RepositorioClient metodosCrud;
    
    public List<Client> getAll(){
      return metodosCrud.getAll();  
    }
    
    public Optional<Client> getClient(int clientId){
      return metodosCrud.getClient(clientId);  
    }
    
    public Client save(Client client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<Client> evt= metodosCrud.getClient(client.getIdClient());
            if(evt.isEmpty()){
                return metodosCrud.save(client);
            }else{
                return client;
            }
        }
    }
    
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> evt= metodosCrud.getClient(client.getIdClient());
            if(!evt.isEmpty()){
                if(client.getName()!=null){
                    evt.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    evt.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    evt.get().setPassword(client.getPassword());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    
    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
