package xbc.tut.springbootjpa.service;

import java.util.List;
import java.util.Optional;
import xbc.tut.springbootjpa.model.Course;

public interface CourseService {

  void add(Course course);

  void update(Course course);

  void delete(Course course);

  Optional<Course> get(int id);

  List<Course> getAll();

  List<Course> getAllOrderByVolume();

  Course getCourseByLabel(String cl );

}
