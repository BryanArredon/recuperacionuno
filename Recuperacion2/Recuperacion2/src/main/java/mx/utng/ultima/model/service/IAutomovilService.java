package mx.utng.ultima.model.service;


import java.util.List;

import mx.utng.ultima.model.entity.Automovil;



public interface IAutomovilService {
    List<Automovil> list();
    void save(Automovil automovil);
    Automovil getById(Long id);
    void delete(Long id);
}

