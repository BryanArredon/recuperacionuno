package mx.utng.ultima.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.ultima.model.dao.IAutomovilDao;
import mx.utng.ultima.model.entity.Automovil;
/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class AutomovilServiceImpl implements IAutomovilService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IAutomovilDao automovilDao;

    @Transactional(readOnly = true)
    @Override
    public List<Automovil> list() {
        return automovilDao.list();
    }

    @Transactional
    @Override
    public void save(Automovil automovil) {
        automovilDao.save(automovil);
    }

    @Transactional(readOnly = true)
    @Override
    public Automovil getById(Long id) {
        return automovilDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        automovilDao.delete(id);
    }
    
}

