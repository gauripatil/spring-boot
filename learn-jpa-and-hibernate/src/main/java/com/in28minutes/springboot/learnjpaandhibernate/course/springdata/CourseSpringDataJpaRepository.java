package com.in28minutes.springboot.learnjpaandhibernate.course.springdata;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Integer> {

}
