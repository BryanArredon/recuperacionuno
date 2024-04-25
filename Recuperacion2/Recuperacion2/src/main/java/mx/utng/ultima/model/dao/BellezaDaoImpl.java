package mx.utng.ultima.model.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.Belleza;

@Repository
public class BellezaDaoImpl implements IBellezaDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Belleza> list() {
        return em.createQuery("from Belleza").getResultList();
    }

    @Override
    public void save(Belleza belleza) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(belleza.getId() != null && belleza.getId()>0){
            em.merge(belleza);
        }else{
            //Registro nuevo al usar persist
            em.persist(belleza);
        }
    }

    @Override
    public Belleza getById(Long id) {
        return em.find(Belleza.class, id);
    }

    @Override
    public void delete(Long id) {
      Belleza belleza = getById(id);
      em.remove(belleza);
    }
    

}
