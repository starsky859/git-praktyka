package pl.kurs.schooldiary.service;

import org.springframework.stereotype.Service;
import pl.kurs.schooldiary.model.Teacher;
import pl.kurs.schooldiary.repository.TeacherRepository;

@Service
public class TeacherManagementService extends GenericManagementService<Teacher, TeacherRepository> {


    public TeacherManagementService(TeacherRepository repository) {
        super(repository);
    }
}
