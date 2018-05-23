package xbc.tut.springbootjpa.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xbc.tut.springbootjpa.dao.CourseRepo;
import xbc.tut.springbootjpa.model.Course;

@Service ("courseService")
public class CourseServiceImp implements CourseService{

  @Autowired
  private CourseRepo courseRepo;

  @Override
  public void add(Course course) {
     courseRepo.save(course);
  }

  @Override
  public void update(Course course) {
    courseRepo.saveAndFlush(course);
  }

  @Override
  public void delete(Course course) {
    courseRepo.delete(course);
  }

  @Override
  public Optional<Course> get(int id) {
    return courseRepo.findById(id);
  }

  @Override
  public List<Course> getAll() {
    return courseRepo.findAll();
  }

  @Override
  public List<Course> getAllOrderByVolume() {
    return courseRepo.findAllByOrderByVolume();
  }

  @Override
  public Course getCourseByLabel(String cl) {
    return courseRepo.findCourseByCourseLabel(cl);
  }
}
