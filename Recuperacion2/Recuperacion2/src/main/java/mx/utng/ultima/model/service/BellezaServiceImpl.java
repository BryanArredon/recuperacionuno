package mx.utng.ultima.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.ultima.model.dao.IBellezaDao;
import mx.utng.ultima.model.entity.Belleza;

/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class BellezaServiceImpl implements IBellezaService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IBellezaDao bellezaDao;

    @Transactional(readOnly = true)
    @Override
    public List<Belleza> list() {
        return bellezaDao.list();
    }

    @Transactional
    @Override
    public void save(Belleza belleza) {
        bellezaDao.save(belleza);
    }

    @Transactional(readOnly = true)
    @Override
    public Belleza getById(Long id) {
        return bellezaDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        bellezaDao.delete(id);
    }
    
}

