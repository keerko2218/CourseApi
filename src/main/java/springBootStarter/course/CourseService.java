package springBootStarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service

public class CourseService {

    @Autowired
    CourseRepository courseRepository;


    public List<Course> getAllCourses(String topicId){
        //return courses;
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    //getting a single resource
    public Course getCourse(String id){
        //filters the Course by if the id equals the id passed in and only takes the first element
        //return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return courseRepository.findOne(id);
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Course course){

        courseRepository.save(course);
    }

    public void deleteCourse(String id){
        courseRepository.delete(id);
    }
}

