package mx.utng.ultima.model.service;


import java.util.List;

import mx.utng.ultima.model.entity.Television;

public interface ITelevisionService {
    List<Television> list();
    void save(Television television);
    Television getById(Long id);
    void delete(Long id);
}

