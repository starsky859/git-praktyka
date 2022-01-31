package pl.kurs.schooldiary.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.schooldiary.exceptions.NoEntityException;
import pl.kurs.schooldiary.exceptions.WrongIdException;
import pl.kurs.schooldiary.interfaces.Identificationable;
import pl.kurs.schooldiary.interfaces.ManagementInterface;

import java.util.List;


public class GenericManagementService<T extends Identificationable, U extends JpaRepository<T, Long>> implements ManagementInterface<T> {

    protected U repository;

    public GenericManagementService(U repository) {
        this.repository = repository;
    }


    @Override
    public T add(T entity) throws NoEntityException, WrongIdException {
        if (entity == null)
            throw new NoEntityException("No entity for add!");
        if (entity.getId() != null)
            throw new WrongIdException("There is an id in entity!");
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) throws WrongIdException, NoEntityException {
        if (id == null)
            throw new WrongIdException("Wrong id!");
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new NoEntityException("No entity found!");
        }
    }

    @Override
    public T edit(T entity) throws NoEntityException, WrongIdException {
        if (entity == null)
            throw new NoEntityException("No entity for edit!");
        if (entity.getId() == null)
            throw new WrongIdException("Wrong id!");
        return repository.save(entity);
    }

    @Override
    public T show(Long id) throws NoEntityException {
        return repository.findById(id)
                .orElseThrow(() -> new NoEntityException("No entity found!"));
    }

    @Override
    public List<T> showAll() {
        return repository.findAll();
    }
}
