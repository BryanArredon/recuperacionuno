package mx.utng.ultima.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.ultima.model.dao.ITelevisionDao;
import mx.utng.ultima.model.entity.Television;

/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class TelevisionServiceImpl implements ITelevisionService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private ITelevisionDao televisionDao;

    @Transactional(readOnly = true)
    @Override
    public List<Television> list() {
        return televisionDao.list();
    }

    @Transactional
    @Override
    public void save(Television television) {
        televisionDao.save(television);
    }

    @Transactional(readOnly = true)
    @Override
    public Television getById(Long id) {
        return televisionDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        televisionDao.delete(id);
    }
    
}

