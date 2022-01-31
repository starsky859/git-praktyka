package pl.kurs.schooldiary.interfaces;

import pl.kurs.schooldiary.exceptions.NoEntityException;
import pl.kurs.schooldiary.exceptions.WrongIdException;

import java.util.List;

public interface ManagementInterface<T> {

    T add(T entity) throws NoEntityException, NoEntityException, WrongIdException;

    void delete(Long id) throws WrongIdException, NoEntityException;

    T edit(T entity) throws NoEntityException, WrongIdException;

    T show(Long id) throws NoEntityException;

    List<T> showAll();
}
