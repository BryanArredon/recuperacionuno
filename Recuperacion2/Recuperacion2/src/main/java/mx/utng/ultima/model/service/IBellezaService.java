package mx.utng.ultima.model.service;


import java.util.List;

import mx.utng.ultima.model.entity.Belleza;



public interface IBellezaService {
    List<Belleza> list();
    void save(Belleza belleza);
    Belleza getById(Long id);
    void delete(Long id);
}

