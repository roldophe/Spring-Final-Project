package dev.radom.restaurant.api.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByUuidAndIsDeletedFalse(String uuid);
    List<User> findUserByIsDeletedTrue();
    Optional<User> findUserByUuid(String uuid);
    List<User> findUserByIsDeletedFalse();
    Boolean existsByUsernameOrEmail(String username,String email);
    Boolean existsByUsername(String username);
}
