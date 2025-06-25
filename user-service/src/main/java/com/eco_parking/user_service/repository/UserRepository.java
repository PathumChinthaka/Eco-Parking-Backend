package com.eco_parking.user_service.repository;

import com.eco_parking.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT id FROM USER ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Long generateId();

    Optional<User> findById(Long userId);
    boolean existsByEmail(String email);
    boolean existsById(Long userId);
    User findByName(String userName);

    void deleteById(Long userId);
}
