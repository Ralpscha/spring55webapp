package nl.ralphvanschaik.spring5webapp.repositories;

import nl.ralphvanschaik.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
