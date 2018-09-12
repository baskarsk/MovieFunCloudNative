package org.superbiz.moviefun;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	private static Log logger = LogFactory.getLog(HomeController.class);

	private final MoviesBean moviesBean;
	private final MovieStubData movieData;
	
	
	public HomeController(MoviesBean moviesBean,MovieStubData movieData){
		
		this.moviesBean = moviesBean;
		this.movieData = movieData;
		
	}
	
	@GetMapping("/")
	public String index(){
		
//		String index="index";
		
		return "index";
	}
	
	
	@GetMapping("/setup")
//	@Transactional
	public String setup(Map<String,Object> model){
		
		for(Movie movie : movieData.load()){
			
			moviesBean.addMovie(movie);
			
		}
		model.put("movies", moviesBean.getMovies());
		return "setup";
		
	}
}
