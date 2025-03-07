package com.pentryyy.horoscope_prediction.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pentryyy.horoscope_prediction.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    @EntityGraph(attributePaths = {"role"})
    Optional<User> findByUsername(String username);

    @EntityGraph(attributePaths = {"role"})
    Page<User> findAll(Pageable pageable);
}