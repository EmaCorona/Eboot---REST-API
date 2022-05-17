package it.corona.eboot.service;

import it.corona.eboot.model.Review;
import it.corona.eboot.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

   public List<Review> findByProductId(Integer productId){
        return reviewRepository.findByProductId(productId);
   }
}
