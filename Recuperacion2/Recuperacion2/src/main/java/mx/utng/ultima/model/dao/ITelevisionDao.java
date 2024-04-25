package mx.utng.ultima.model.dao;


import java.util.List;

import mx.utng.ultima.model.entity.Television;


public interface ITelevisionDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Television> list();

    //Guardar un estudiante
    void save(Television television);

    //Obterner un estudiante en especifico a partir del id
    Television getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}


