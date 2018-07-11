/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.Movies;

import com.movies.business.ProcessOperations;
import com.movies.pojos.Movie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

/**
 *
 * @author sravan
 */
public class HomeControllerTest {
    
    public HomeControllerTest() {
    }
    
    @Mock
    ProcessOperations processOperations;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of home method, of class HomeController.
     */
    @Test
    public void testHome() {
        System.out.println("home");
        HomeController instance = new HomeController();
        String expResult = "welcome";
        String result = instance.home();
        assertEquals(expResult, result);
    }

    /**
     * Test of postMovie method, of class HomeController.
     */
    @Test
    public void testPostMovieShouldPass() {
        System.out.println("postMovie");
        Map<String, Object> payload = new HashMap();
        payload.put("genre", "a");
        payload.put("movieName", "a");
        payload.put("directorName", "a");
        payload.put("budget", "200");
        Movie movie = new Movie();
        int expResult = 1;
        movie.setMovieName("a");
        movie.setDirectorName("a");
        movie.setGenre("a");
        movie.setBudget("200");
        HomeController instance = new HomeController();
        instance.setProcessOperations(processOperations);
        Mockito.when(processOperations.postMovie(any(Movie.class))).thenReturn(true);
        
        int result = instance.postMovie(payload);
        assertEquals(expResult, result);
        assertNotNull(result);
        verify(processOperations).postMovie(refEq(movie));
    }
    
    @Test
    public void testPostMovieShouldFail() {
        System.out.println("postMovie");
        Map<String, Object> payload = new HashMap();
        payload.put("genre", "a");
        payload.put("movieName", "a");
        payload.put("directorName", "a");
        payload.put("budget", "200");
        Movie movie = new Movie();
        int expResult = 0;
        movie.setMovieName("a");
        movie.setDirectorName("a");
        movie.setGenre("a");
        movie.setBudget("200");
        HomeController instance = new HomeController();
        instance.setProcessOperations(processOperations);
        Mockito.when(processOperations.postMovie(any(Movie.class))).thenReturn(false);
        
        int result = instance.postMovie(payload);
        assertEquals(expResult, result);
        assertNotNull(result);
        verify(processOperations).postMovie(refEq(movie));
    }
    
    
    /**
     * Test of getMovie method, of class HomeController.
     */
    
    @Test
    public void testGetMovie() {
        System.out.println("getMovie");
        List<Movie> movies = new ArrayList<Movie>();
        Movie movie1 = new Movie();
        movie1.setId(1);
        movie1.setMovieName("test1");
        movie1.setDirectorName("test");
        movie1.setGenre("a");
        movie1.setBudget("200");
        Movie movie2 = new Movie();
        movie2.setId(2);
        movie2.setMovieName("test1");
        movie2.setDirectorName("test");
        movie2.setGenre("a");
        movie2.setBudget("200");
        HomeController instance = new HomeController();
        instance.setProcessOperations(processOperations);
        Mockito.when(processOperations.getMovies()).thenReturn(movies);
        List<Movie> result = instance.getMovie();
        assertNotNull(result);
        verify(processOperations).getMovies();
       
    }

    /**
     * Test of deleteMovie method, of class HomeController.
     */
    @Test
    public void testDeleteMovieShouldPass() {
        System.out.println("deleteMovie");
        HomeController instance = new HomeController();
        instance.setProcessOperations(processOperations);
        Mockito.when(processOperations.deleteMovie(anyString())).thenReturn(true);
        int result = instance.deleteMovie(anyString());
        int expResult = 1;
        assertEquals(expResult, result);
        assertNotNull(result);
        verify(processOperations).deleteMovie(anyString());
    }
    
    /**
     * Test of deleteMovie method, of class HomeController.
     */
    @Test
    public void testDeleteMovieShouldFail() {
        System.out.println("deleteMovie");
        HomeController instance = new HomeController();
        instance.setProcessOperations(processOperations);
        Mockito.when(processOperations.deleteMovie(anyString())).thenReturn(false);
        int result = instance.deleteMovie(anyString());
        int expResult = 0;
        assertEquals(expResult, result);
        assertNotNull(result);
        verify(processOperations).deleteMovie(anyString());
    }

    /**
     * Test of putMovie method, of class HomeController.
     */
    @Test
    public void testPutMovie() {
        System.out.println("putMovie");
        Map<String, Object> payload = new HashMap();
        payload.put("id", "1");
        payload.put("genre", "a");
        payload.put("movieName", "a");
        payload.put("directorName", "a");
        payload.put("budget", "200");
        Movie movie = new Movie();
        int expResult = 1;
        movie.setId(1);
        movie.setMovieName("a");
        movie.setDirectorName("a");
        movie.setGenre("a");
        movie.setBudget("200");
        HomeController instance = new HomeController();
        instance.setProcessOperations(processOperations);
        Mockito.when(processOperations.putMovie(any(Movie.class))).thenReturn(true);
        
        int result = instance.putMovie(payload);
        assertEquals(expResult, result);
        assertNotNull(result);
        verify(processOperations).putMovie(refEq(movie));
    }
    
    /**
     * Test of putMovie method, of class HomeController.
     */
    @Test
    public void testPutMovieShouldFail() {
        System.out.println("putMovie");
        Map<String, Object> payload = new HashMap();
        payload.put("id", "1");
        payload.put("genre", "a");
        payload.put("movieName", "a");
        payload.put("directorName", "a");
        payload.put("budget", "200");
        Movie movie = new Movie();
        int expResult = 0;
        movie.setId(1);
        movie.setMovieName("a");
        movie.setDirectorName("a");
        movie.setGenre("a");
        movie.setBudget("200");
        HomeController instance = new HomeController();
        instance.setProcessOperations(processOperations);
        Mockito.when(processOperations.putMovie(any(Movie.class))).thenReturn(false);
        
        int result = instance.putMovie(payload);
        assertEquals(expResult, result);
        assertNotNull(result);
        verify(processOperations).putMovie(refEq(movie));
    }
    
}
