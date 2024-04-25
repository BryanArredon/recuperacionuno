package mx.utng.ultima.model.dao;


import java.util.List;

import mx.utng.ultima.model.entity.Belleza;



public interface IBellezaDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Belleza> list();

    //Guardar un estudiante
    void save(Belleza belleza);

    //Obterner un estudiante en especifico a partir del id
    Belleza getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}


