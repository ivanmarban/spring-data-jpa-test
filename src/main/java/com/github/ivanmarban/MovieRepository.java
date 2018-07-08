package com.github.ivanmarban;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("Select m FROM Movie m WHERE LOWER(m.title) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    public List<Movie> search(@Param("searchTerm") String searchTerm);

}
