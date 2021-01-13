package ie.urlhandler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.urlhandler.model.URL;

/**
 * JPA repository interface for performing operations on the urls table
 */
@Repository
public interface URLRepository extends JpaRepository<URL, Long> {

}
