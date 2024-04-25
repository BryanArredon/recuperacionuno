package mx.utng.ultima.model.dao;


import java.util.List;

import mx.utng.ultima.model.entity.Automovil;



public interface IAutomovilDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Automovil> list();

    //Guardar un estudiante
    void save(Automovil automovil);

    //Obterner un estudiante en especifico a partir del id
    Automovil getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}


