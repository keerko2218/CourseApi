package springBootStarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springBootStarter.topic.Topic;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;


    @RequestMapping("/topics/{id}/courses")
    private List<Course> getAllCourses(@PathVariable String id){
        //return "All Courses";
        return courseService.getAllCourses(id);

    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    //getting a single resource
    //curly brackets indicate variable
    public Course getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }

    @PostMapping("/topics/{topicId}/courses")
    // POST request
    //@RequestBody tells spring MVC that the request payload is going contain a JSON representation of the course instance
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "",""));
        courseService.addCourse(course);
    }

    @PutMapping("/topics/{topicId}/courses/{id}")
    public void updateCourse( @RequestBody Course course,@PathVariable String topicId,@PathVariable String id){
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }

    @DeleteMapping("/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }


}

