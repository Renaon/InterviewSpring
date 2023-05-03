package com.geekbrains.Interview.service;

import com.geekbrains.Interview.exceptions.UserExistsException;
import com.geekbrains.Interview.repository.StudentRepository;
import com.geekbrains.Interview.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student loadStudentByName(String name){
        return studentRepository.loadStudentByName(name);
    }

    public Student loadStudentById(Long id){
        return studentRepository.getReferenceById(id);
    }

    public void add(Student student){
        if(studentRepository.loadStudentByName(student.getName()) == null){
            studentRepository.save(student);
        }
        else {
            throw new UserExistsException("Student exists");
        }
    }

    public void delete(Long id) {
            studentRepository.delete(studentRepository.getReferenceById(id));
    }

    public void changeMark(String name, Integer mark){
        studentRepository.changeMark(mark, name);
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }
}
