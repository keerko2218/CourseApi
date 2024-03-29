package springBootStarter.topic;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service

public class TopicService {

    private List<Topic> topics = new ArrayList<>( Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework description"),
            new Topic("java", "Core Java", "Core Java Description"),
            new Topic("javascript", "JavaScript", "JavaScript Description")
    ));

    public List<Topic> getAllTopics(){
        return topics;
    }

    //getting a single resource
    public Topic getTopic(String id){
        //filters the topic by if the id equals the id passed in and only takes the first element
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic){
        for(int i =0; i<topics.size();i++){
            Topic t = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id){
        for(Topic t : topics){
            if(id.equals(t.getId()) /*&& topic.getName().equals(t.getName()) && topic.getDescription().equals(t.getDescription())*/){
                topics.remove(t);
            }
        }
    }
}

