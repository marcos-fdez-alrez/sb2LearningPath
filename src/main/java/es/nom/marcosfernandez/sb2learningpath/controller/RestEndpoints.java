package es.nom.marcosfernandez.sb2learningpath.controller;

import es.nom.marcosfernandez.sb2learningpath.config.PropertiesConfiguration;
import es.nom.marcosfernandez.sb2learningpath.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
public class RestEndpoints {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${default.course.name}")
    private String defaultName;

    @Value("${default.course.chapters}")
    private Integer defaultChaptersCount;

    @Autowired
    PropertiesConfiguration propertiesConfiguration;

    //@GetMapping("/defaultCourse")
    @RequestMapping(value = "/defaultCourse",method = RequestMethod.GET)
    public Course getDefaultCourse(@RequestParam(value = "name", defaultValue = "Spring Boot", required = false) String name,
                              @RequestParam(value = "chapterCount", defaultValue = "2", required = false) Integer chapterCount) {
        logger.info("Started getDefaultCourse method!");
        return new Course(1L,defaultName,defaultChaptersCount);
    }

    //@GetMapping("/courses")
    @RequestMapping(value = "/courses",method = RequestMethod.GET)
    public Course getEndpoint(@RequestParam(value = "name", defaultValue = "Spring Boot", required = false) String name,
                              @RequestParam(value = "chapterCount", defaultValue = "2", required = false) Integer chapterCount) {
        logger.info("Started getEndpoint method!");
        return new Course(1L,name,chapterCount);
    }

    // Spring MVC
    //@GetMapping("/courses/{id}")
    @RequestMapping(value = "/courses/{id}",method = RequestMethod.GET)
    public Course getEndpoint(@PathVariable("id") String id) {
        logger.info("Started getEndpoint method!");
        return new Course(Long.parseLong(id), "defaultName",0);
    }

    /* JAX - RS
        @GET
        @Path("/courses/{id}")
        public Course getEndpoint(@PathParam("id") String id) {
            return new Course(Long.parseLong(id), "defaultName",0);
        }
    */

    // Spring MVC
    //@GetMapping("/properties")
    @RequestMapping(value = "/properties",method = RequestMethod.GET)
    public HashMap<String,Object> getProperties() {

        logger.info("Started properties method!");

        HashMap<String, Object> map = new HashMap<>();

        map.put("firstProperty",propertiesConfiguration.getFirstProperty());
        map.put("secondProperty",propertiesConfiguration.getSecondProperty());
        map.put("thirdProperty",propertiesConfiguration.getThirdProperty());
        map.put("fourthProperty",propertiesConfiguration.getFourthProperty());

        return map;
    }

    //@PostMapping("courses")
    @RequestMapping(value = "/courses",method = RequestMethod.POST)
    public String postEndpoint(@RequestBody Course course) {

        logger.info("Started postEndpoint method!");

        return "Your course with id " + course.getId() + " named "+ course.getName() + " with " + course.getChapterCount() + " chapters saved successfully";
    }

}
