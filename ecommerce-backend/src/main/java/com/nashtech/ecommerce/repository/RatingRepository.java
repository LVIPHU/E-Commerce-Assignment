package com.nashtech.ecommerce.repository;

import com.nashtech.ecommerce.entity.Rating;
import com.nashtech.ecommerce.entity.RatingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, RatingId> {
    @Query("SELECT avg(r.scores) FROM Rating r  WHERE r.ratingId.productId = :product_id")
    Optional<Float> findAVGRatingOfProduct(@Param("product_id") Long productId);
}
