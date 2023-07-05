package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    private CourseJdbcRepository repository;

    @Autowired
    private CourseJpaRepository repository;


    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS Jpa!!", "Gauri"));
        repository.insert(new Course(2, "Learn Java Jpa!!", "Gauri"));
        repository.insert(new Course(3, "Learn React Jpa!!", "Gauri"));

        repository.deleteById(1);
        System.out.println(repository.selectById(2));
        System.out.println(repository.selectById(3));
    }
}
