package springBootStarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    private List<Topic> getAllTopics(){
        //return "All Topics";
        return topicService.getAllTopics();

    }

    @RequestMapping("/topics/{id}")
    //getting a single resource
    //curly brackets indicate variable
    public Topic getTopic( @PathVariable String id){
        return topicService.getTopic(id);
    }


    @PostMapping("/topics")
    // POST request
    //@RequestBody tells spring MVC that the request payload is going contain a JSON representation of the topic instance
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }

    @PutMapping("/topics/{id}")
    public void updateTopic(@PathVariable String id, @RequestBody Topic topic){
        topicService.updateTopic(id, topic);
    }

}

