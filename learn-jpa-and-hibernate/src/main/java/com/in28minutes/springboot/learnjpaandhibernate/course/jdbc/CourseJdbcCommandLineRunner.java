package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdata.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;


    @Override
    public void run(String... args) throws Exception {
//        repository.insert(new Course(1, "Learn AWS Jpa!!", "Gauri"));
//        repository.insert(new Course(2, "Learn Java Jpa!!", "Gauri"));
//        repository.insert(new Course(3, "Learn React Jpa!!", "Gauri"));
//
//        repository.deleteById(1);
//        System.out.println(repository.selectById(2));
//        System.out.println(repository.selectById(3));

        repository.save(new Course(1, "Learn AWS - Spring Data Jpa!!", "Gauri"));
        repository.save(new Course(2, "Learn Java - Spring Data Jpa!!", "Gauri"));
        repository.save(new Course(3, "Learn React - Spring Data Jpa!!", "Gauri"));

        repository.deleteById(1);
        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));

        System.out.println(repository.findByAuthor("Gauri"));
        System.out.println(repository.findByAuthor(""));

        System.out.println(repository.findByName("Learn AWS - Spring Data Jpa!!"));
        System.out.println(repository.findByName("Learn React - Spring Data Jpa!!"));
    }
}
