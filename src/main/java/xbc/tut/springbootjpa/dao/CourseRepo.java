package xbc.tut.springbootjpa.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import xbc.tut.springbootjpa.model.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

  @Override
  <S extends Course> S save(S entity);

  @Override
  <S extends Course> S saveAndFlush(S entity);

  @Override
  void delete(Course entity);

  @Override
  Optional<Course> findById(Integer integer);

  @Override
  List<Course> findAll();

  Course findCourseByCourseLabel(String courseLabel);

  List<Course> findAllByOrderByVolume();
}
