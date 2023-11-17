package dev.radom.restaurant.api.order.repository;

import dev.radom.restaurant.api.order.model.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CrewRepository extends JpaRepository<Crew, Long> {
    Optional<Crew> findCrewByUuid(String uuid);

    boolean existsCrewByFirstNameAndLastNameAndDob(String firstName, String lastName, LocalDate dob);
}
