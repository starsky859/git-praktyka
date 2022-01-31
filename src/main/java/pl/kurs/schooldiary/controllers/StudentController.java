package pl.kurs.schooldiary.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.kurs.schooldiary.dto.StudentDto;
import pl.kurs.schooldiary.dto.TeacherDto;
import pl.kurs.schooldiary.exceptions.NoEntityException;
import pl.kurs.schooldiary.exceptions.WrongIdException;
import pl.kurs.schooldiary.model.Student;
import pl.kurs.schooldiary.model.Teacher;
import pl.kurs.schooldiary.service.StudentManagementService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
@Validated
public class StudentController {

    private final StudentManagementService studentManagementService;
    private final ModelMapper mapper;

    public StudentController(StudentManagementService studentManagementService, ModelMapper mapper) {
        this.studentManagementService = studentManagementService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<StudentDto> addStudent(@RequestBody @Valid StudentDto studentDto) throws WrongIdException, NoEntityException {
        Student addedStudent = studentManagementService.add(mapper.map(studentDto, Student.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(addedStudent, StudentDto.class));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable(name = "id") long id) throws NoEntityException {
        Student loadedStudent = studentManagementService.show(id);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.map(loadedStudent, StudentDto.class));
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudent() {
        List<Student> studentList = studentManagementService.showAll();
        return ResponseEntity.ok(
                studentList.stream()
                        .map(x -> mapper.map(x, StudentDto.class))
                        .collect(Collectors.toList())
        );


    }
}
