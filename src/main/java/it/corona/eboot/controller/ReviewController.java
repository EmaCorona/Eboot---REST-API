package it.corona.eboot.controller;

import it.corona.eboot.model.Review;
import it.corona.eboot.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Lista di tutte le recensioni
    @GetMapping("/all")
    public List<Review> findAll(){
        return reviewService.findAll();
    }


    // Lista di tutte le recensioni in base all'Id di un prodotto
    @GetMapping("/{productId}")
    public List<Review> findByProductId(@PathVariable Integer productId){
        return reviewService.findByProductId(productId);
    }



}
