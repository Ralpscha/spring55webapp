package nl.ralphvanschaik.spring5webapp.repositories;

import nl.ralphvanschaik.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
