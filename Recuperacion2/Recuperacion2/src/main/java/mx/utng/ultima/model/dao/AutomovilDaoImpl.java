package mx.utng.ultima.model.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.Automovil;

@Repository
public class AutomovilDaoImpl implements IAutomovilDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Automovil> list() {
        return em.createQuery("from Automovil").getResultList();
    }

    @Override
    public void save(Automovil automovil) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(automovil.getId() != null && automovil.getId()>0){
            em.merge(automovil);
        }else{
            //Registro nuevo al usar persist
            em.persist(automovil);
        }
    }

    @Override
    public Automovil getById(Long id) {
        return em.find(Automovil.class, id);
    }

    @Override
    public void delete(Long id) {
      Automovil automovil = getById(id);
      em.remove(automovil);
    }
}
