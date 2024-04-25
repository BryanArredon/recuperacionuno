package mx.utng.ultima.model.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.Television;

@Repository
public class TelevisionDaoImpl implements ITelevisionDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Television> list() {
        return em.createQuery("from Television").getResultList();
    }

    @Override
    public void save(Television television) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(television.getId() != null && television.getId()>0){
            em.merge(television);
        }else{
            //Registro nuevo al usar persist
            em.persist(television);
        }
    }

    @Override
    public Television getById(Long id) {
        return em.find(Television.class, id);
    }

    @Override
    public void delete(Long id) {
      Television television = getById(id);
      em.remove(television);
    }
    

}
