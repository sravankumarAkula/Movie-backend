
package com.movies.Movies;

import com.movies.business.ProcessOperations;
import com.movies.pojos.Movie;
import com.movies.pojos.ProcessingResult;
import java.util.List;
import java.util.Map;
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
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @ResponseBody
    public String home(){
        return "welcome";
    }
    
    @CrossOrigin(origins = "http://localhost:8084")
    @RequestMapping(value = "/postMovie", method = RequestMethod.POST)
    @ResponseBody
    public ProcessingResult postMovie(@RequestBody Map<String, Object> payload){
        ProcessingResult processingResult = new ProcessingResult();
        System.out.println(payload);
        Movie movie = new Movie();
        movie.setMovieName(payload.get("movieName").toString());
        movie.setDirectorName(payload.get("directorName").toString());
        movie.setGenre(payload.get("genre").toString());
        movie.setBudget(payload.get("budget").toString());
        try{
            boolean isPosted = ProcessOperations.postMovie(movie);  
            System.out.println("isPosted " + isPosted);
            if(isPosted){
                processingResult.setResult("success");
                processingResult.setDevloperMessage("success");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            processingResult.setResult("error");
            processingResult.setDevloperMessage("error");
        }
        return processingResult;
    }
    
    @CrossOrigin(origins = "http://localhost:8084")
    @RequestMapping(value = "/getMovies", method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> getMovie(){
        return ProcessOperations.getMovies();
    }
    
    @CrossOrigin(origins = "http://localhost:8084")
    @RequestMapping(value = "/deleteMovie", method = RequestMethod.DELETE)
    @ResponseBody
    public ProcessingResult deleteMovie(@RequestParam(value="id", required=true) String id){
        ProcessingResult processingResult = new ProcessingResult();
        System.out.println("id to delete " + id);
        try{
            boolean isDeleted = ProcessOperations.deleteMovie(id);  
            System.out.println("is deleted " + isDeleted);
            if(isDeleted){
                processingResult.setResult("success");
                processingResult.setDevloperMessage("success");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            processingResult.setResult("error");
            processingResult.setDevloperMessage("error");
        }
        return processingResult;
    }
    
    @CrossOrigin(origins = "http://localhost:8084")
    @RequestMapping(value = "/putMovie", method = RequestMethod.PUT)
    @ResponseBody
    public ProcessingResult putMovie(@RequestBody Map<String, Object> payload){
        ProcessingResult processingResult = new ProcessingResult();
        System.out.println(payload);
        Movie movie = new Movie();
        movie.setId(Integer.parseInt(payload.get("id").toString()));
        movie.setMovieName(payload.get("movieName").toString());
        movie.setDirectorName(payload.get("directorName").toString());
        movie.setGenre(payload.get("genre").toString());
        movie.setBudget(payload.get("budget").toString());
        try{
            boolean isUpdated = ProcessOperations.putMovie(movie);  
            System.out.println("is udpated " + isUpdated);
            if(isUpdated){
                processingResult.setResult("success");
                processingResult.setDevloperMessage("success");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            processingResult.setResult("error");
            processingResult.setDevloperMessage("error");
        }
        return processingResult;
    }
    
}
