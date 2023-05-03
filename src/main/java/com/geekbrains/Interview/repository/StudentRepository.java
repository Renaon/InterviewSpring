package com.geekbrains.Interview.repository;

import com.geekbrains.Interview.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s where s.name like ?1")
    Student loadStudentByName(String name);


    @Transactional
    @Modifying
    @Query("update Student s set s.mark = ?1 where s.name = ?2")
    void changeMark(Integer mark, String name);


}