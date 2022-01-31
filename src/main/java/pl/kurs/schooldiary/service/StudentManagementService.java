package pl.kurs.schooldiary.service;

import org.springframework.stereotype.Service;
import pl.kurs.schooldiary.model.Student;
import pl.kurs.schooldiary.repository.StudentRepository;


@Service
public class StudentManagementService extends GenericManagementService<Student, StudentRepository> {

    public StudentManagementService(StudentRepository repository) {
        super(repository);
    }
}
