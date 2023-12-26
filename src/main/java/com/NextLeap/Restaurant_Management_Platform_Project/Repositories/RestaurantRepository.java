package com.NextLeap.Restaurant_Management_Platform_Project.Repositories;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Restaurant.Entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,String> {

    Optional<Restaurant> findByNameIgnoreCase(String name);

    Page<Restaurant> findByOrderByRatingDesc(Pageable pageable);
    Page<Restaurant> findTop10ByOrderByRatingDesc(Pageable pageable);


    // Pagination, sorting, and filtering by cuisine, rating, and average cost
    @Query(value = "SELECT DISTINCT r.* FROM restaurants r " +
            "WHERE ((:cuisineSize = 0) OR (r.id IN " +
             "(SELECT rc.restaurant_id FROM restaurant_cuisine rc "+
            "JOIN cuisines c ON rc.cuisine_id = c.id " +
            "WHERE c.name IN :cuisine))) "  +
            "AND ( r.rating >= :ratingThreshold) " +
            "AND (r.average_cost >= :averageCostMin AND r.average_cost <= :averageCostMax) " +
            "ORDER BY " +
            "CASE WHEN :sortBy = 'rating' AND :sortOrder = 'DESC' THEN r.rating END DESC, " +
            "CASE WHEN :sortBy = 'rating' AND :sortOrder = 'ASC' THEN r.rating END ASC, " +
            "CASE WHEN :sortBy = 'averageCost' AND :sortOrder = 'DESC' THEN r.average_cost END DESC, " +
            "CASE WHEN :sortBy = 'averageCost' AND :sortOrder = 'ASC' THEN r.average_cost END ASC " +
            "LIMIT :limit OFFSET :offSet", nativeQuery = true)
    List<Restaurant> findRestaurantsWithFilters(
            @Param("cuisine") List<String> cuisine,
            @Param("cuisineSize") Integer cuisineSize,
            @Param("ratingThreshold") Double ratingThreshold,
            @Param("averageCostMin") Integer averageCostMin,
            @Param("averageCostMax") Integer averageCostMax,
            @Param("sortBy") String sortBy,
            @Param("sortOrder") String sortOrder,
            @Param("limit") Integer limit,
            @Param("offSet") Integer offSet);


    @Query(value = "SELECT DISTINCT r.* FROM restaurants r JOIN restaurant_cuisine rc " +
            "ON r.id = rc.restaurant_id " +
            "JOIN cuisines c ON rc.cuisine_id = c.id WHERE " +
            "c.name IN :cuisineNames " +
            "LIMIT :limit OFFSET :offSet", nativeQuery = true)
    List<Restaurant> findByCuisinesNameIn(@Param("cuisineNames")List<String> cuisineNames,
                                          @Param("limit") Integer limit,
                                          @Param("offSet") Integer offSet);

    @Query(value = "SELECT DISTINCT r.* FROM restaurants r WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) LIMIT 15", nativeQuery = true)
    List<Restaurant> findRestaurantsBySearchTermLimit10(String searchTerm);



}
