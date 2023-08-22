package com.codecool.eventPlanner.repository;


import com.codecool.eventPlanner.model.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    boolean existsById(Long id);

    @Query(value = "SELECT * FROM events LIMIT :limit", nativeQuery = true)
    List<Event> findAllLimitedTo(@Param("limit") int limit);

    List<Event> findByCategoriesIdAndTitleContainingIgnoreCase(Long categoryIdLong, String nameContains);
}
