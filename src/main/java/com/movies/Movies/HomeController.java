
package com.movies.Movies;

import com.movies.business.ProcessOperations;
import com.movies.pojos.Movie;
import com.movies.pojos.ProcessingResult;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sravan
 */
@RestController
public class HomeController {
    
    @Autowired
    private ProcessOperations processOperations;

    public ProcessOperations getProcessOperations() {
        return processOperations;
    }

    public void setProcessOperations(ProcessOperations processOperations) {
        this.processOperations = processOperations;
    }
    
    
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @ResponseBody
    public String home(){
        return "welcome";
    }
    
    @CrossOrigin(origins = "http://localhost:8084")
    @RequestMapping(value = "/postMovie", method = RequestMethod.POST)
    @ResponseBody
    public int postMovie(@RequestBody Map<String, Object> payload){
        ProcessingResult processingResult = new ProcessingResult();
        System.out.println(payload);
        Movie movie = new Movie();
        movie.setMovieName(payload.get("movieName").toString());
        movie.setDirectorName(payload.get("directorName").toString());
        movie.setGenre(payload.get("genre").toString());
        movie.setBudget(payload.get("budget").toString());
        try{
            //ProcessOperations processOperations = new ProcessOperations();
            boolean isPosted = processOperations.postMovie(movie);  
            System.out.println("isPosted " + isPosted);
            if(isPosted){
                return 1;
            }else{
                return 0;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }
    
    @CrossOrigin(origins = "http://localhost:8084")
    @RequestMapping(value = "/getMovies", method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> getMovie(){
        //ProcessOperations processOperations = new ProcessOperations();
        return processOperations.getMovies();
    }
    
    @CrossOrigin(origins = "http://localhost:8084")
    @RequestMapping(value = "/deleteMovie", method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteMovie(@RequestParam(value="id", required=true) String id){
        ProcessingResult processingResult = new ProcessingResult();
        System.out.println("id to delete " + id);
        try{
            //ProcessOperations processOperations = new ProcessOperations();
            boolean isDeleted = processOperations.deleteMovie(id);  
            System.out.println("is deleted " + isDeleted);
            if(isDeleted){
                return 1;
            }else{
                return 0;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }
    
    @CrossOrigin(origins = "http://localhost:8084")
    @RequestMapping(value = "/putMovie", method = RequestMethod.PUT)
    @ResponseBody
    public int putMovie(@RequestBody Map<String, Object> payload){
        ProcessingResult processingResult = new ProcessingResult();
        System.out.println(payload);
        Movie movie = new Movie();
        movie.setId(Integer.parseInt(payload.get("id").toString()));
        movie.setMovieName(payload.get("movieName").toString());
        movie.setDirectorName(payload.get("directorName").toString());
        movie.setGenre(payload.get("genre").toString());
        movie.setBudget(payload.get("budget").toString());
        try{
            //ProcessOperations processOperations = new ProcessOperations();
            boolean isUpdated = processOperations.putMovie(movie);  
            System.out.println("is udpated " + isUpdated);
            if(isUpdated){
                return 1;
            }else{
                return 0;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }
    
}
