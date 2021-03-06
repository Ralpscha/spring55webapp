package nl.ralphvanschaik.spring5webapp.bootstrap;

import nl.ralphvanschaik.spring5webapp.domain.Author;
import nl.ralphvanschaik.spring5webapp.domain.Book;
import nl.ralphvanschaik.spring5webapp.domain.Publisher;
import nl.ralphvanschaik.spring5webapp.repositories.AuthorRepository;
import nl.ralphvanschaik.spring5webapp.repositories.BookRepository;
import nl.ralphvanschaik.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisherDeBezigeBij = new Publisher("De Bezige Bij", "Nederland");
        publisherRepository.save(publisherDeBezigeBij);
        System.out.println("Publisher Count: " + publisherRepository.count());


        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisherDeBezigeBij);
        publisherDeBezigeBij.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisherDeBezigeBij);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development withoudt EJB", "432432");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisherDeBezigeBij);
        publisherDeBezigeBij.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisherDeBezigeBij);

        System.out.println("Started from BootStrapData");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher number of books: " + publisherDeBezigeBij.getBooks().size());


    }
}
