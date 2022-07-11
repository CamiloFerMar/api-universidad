package com.simplespasos.ultimate.universidadbackend.services.implementaciones;

import com.simplespasos.ultimate.universidadbackend.services.contratos.GenericDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class GenericDAOImp <E, R extends CrudRepository<E, Integer>> implements GenericDAO<E> {

    protected final R repository;

    public GenericDAOImp(R repository) {
        this.repository = repository;
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public E save(E generic) {
        return repository.save(generic);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
