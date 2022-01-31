package pl.kurs.schooldiary.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kurs.schooldiary.dto.GradeDto;
import pl.kurs.schooldiary.dto.StudentDto;
import pl.kurs.schooldiary.dto.TeacherDto;
import pl.kurs.schooldiary.exceptions.NoEntityException;
import pl.kurs.schooldiary.exceptions.WrongIdException;
import pl.kurs.schooldiary.model.Grade;
import pl.kurs.schooldiary.model.Student;
import pl.kurs.schooldiary.model.Teacher;
import pl.kurs.schooldiary.service.TeacherManagementService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherManagementService teacherManagementService;
    private final ModelMapper mapper;

    public TeacherController(TeacherManagementService teacherManagementService, ModelMapper mapper) {
        this.teacherManagementService = teacherManagementService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<TeacherDto> addTeacher(@RequestBody TeacherDto teacherDto) throws WrongIdException, NoEntityException {
        Teacher addedTeacher = teacherManagementService.add(mapper.map(teacherDto, Teacher.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(addedTeacher, TeacherDto.class));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable(name = "id") long id) throws NoEntityException {
        Teacher loadedTeacher = teacherManagementService.show(id);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.map(loadedTeacher, TeacherDto.class));
    }

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllTeachers() {
        List<Teacher> teacherList = teacherManagementService.showAll();
        return ResponseEntity.ok(
                teacherList.stream()
                        .map(x -> mapper.map(x, TeacherDto.class))
                        .collect(Collectors.toList())
        );

    }

    @GetMapping("/{id}/grades")
    public ResponseEntity<List<GradeDto>> getGradesByTeacher(@PathVariable(value = "id") long id) throws NoEntityException {
        List<Grade> gradeList = new ArrayList<>(teacherManagementService.show(id).getGrades());
        return ResponseEntity.ok(
                gradeList.stream()
                        .map(x -> mapper.map(x, GradeDto.class))
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<List<StudentDto>> getStudentsByTeacher(@PathVariable(value = "id") long id) throws NoEntityException {
        List<Student> gradeList = new ArrayList<>(teacherManagementService.show(id).getStudents());
        return ResponseEntity.ok(
                gradeList.stream()
                        .map(x -> mapper.map(x, StudentDto.class))
                        .collect(Collectors.toList())
        );
    }

}
