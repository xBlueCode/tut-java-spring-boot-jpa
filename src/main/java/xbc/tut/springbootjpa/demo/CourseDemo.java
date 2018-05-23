package xbc.tut.springbootjpa.demo;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xbc.tut.springbootjpa.model.Course;
import xbc.tut.springbootjpa.service.CourseService;

@Component("courseDemo")
public class CourseDemo implements Demo {

  @Autowired
  private CourseService courseService ;

  private Scanner scanner = new Scanner(System.in);

  @Override
  public void startDemo() {

    boolean running = true ;
    while (running) {
      System.out.println("---------------------------------------------------");
      System.out.println("What do you want to do?");
      System.out.print("Add(a), Update(u), Delete(d), Show(s), Show All(sa), Show All ordered by Vol(sav), Quit(q):  ");

      String choice = scanner.next();

      switch (choice){
        case "a":
          addNewCourse();
          break;
        case "u":
          updateCourse();
          break;
        case "d":
          deleteCourse();
          break;
        case "s":
          showCourse();
          break;
        case "sa":
          showAllCourses();
          break;
        case "sav":
          showAllCoursesOrderedByVol();
          break;
        case "q":
          running = !running;
          break;
        default:
          break ;
      }

    }

  }

  private void addNewCourse() {

    Course course = new Course();

    System.out.println("Add Course: ");

    System.out.print("Course Label (Without spaces): ");
    course.setCourseLabel(scanner.next());

    System.out.print("Course Volume: ");
    course.setVolume(scanner.nextInt());

    courseService.add(course);

  }

  private void updateCourse() {

    Course course = new Course();

    System.out.println("Update Course: ");

    System.out.print("Course ID: ");
    course.setId(scanner.nextInt());

    System.out.print("Course label (Without spaces): ");
    course.setCourseLabel(scanner.next());

    System.out.print("Course Volume: ");
    course.setVolume(scanner.nextInt());

    System.out.println(course);

    courseService.update(course);

  }

  private void deleteCourse() {
    Course course = new Course();

    System.out.print("Delete Course with ID: ");
    course.setId(scanner.nextInt());

    courseService.delete(course);
  }

  private void showCourse() {
    System.out.println("---------------------------------------------------");
    System.out.print("Show Course with the ID: ");

    Optional<Course> course = courseService.get(scanner.nextInt());

  }

  private void showAllCourses() {
    System.out.println("---------------------------------------------------");
    System.out.println("List of Courses");
    courseService.getAll().stream()
        .filter(Objects::nonNull)
        .forEach(System.out::println);
  }

  private void showAllCoursesOrderedByVol() {
    System.out.println("---------------------------------------------------");
    System.out.println("List of Courses");
    courseService.getAllOrderByVolume().stream()
        .filter(Objects::nonNull)
        .forEach(System.out::println);
  }

}