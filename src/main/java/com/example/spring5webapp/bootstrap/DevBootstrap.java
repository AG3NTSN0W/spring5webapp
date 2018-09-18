package com.example.spring5webapp.bootstrap;

import com.example.spring5webapp.model.Author;
import com.example.spring5webapp.model.Book;
import com.example.spring5webapp.model.Publisher;
import com.example.spring5webapp.repositories.AuthorReposity;
import com.example.spring5webapp.repositories.BookRepository;
import com.example.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorReposity authorReposity;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorReposity authorReposity, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorReposity = authorReposity;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }


    private void initData() {

        //
        Publisher publisherA = new Publisher("pName", "pAddress");
        publisherRepository.save(publisherA);

        //Eric
        Author eric = new Author("Eric", ">>>");
        Book ericBooks = new Book("Title1","",publisherA);
        eric.getBooks().add(ericBooks);
        ericBooks.getAuthors().add(eric);

        authorReposity.save(eric);
        bookRepository.save(ericBooks);

        Publisher publisherB = new Publisher("pNameB", "pAddressB");
        publisherRepository.save(publisherB);

        //Rob
        Author rob = new Author("Rob", "????");
        Book robBooks = new Book("Title2","",publisherB);
        rob.getBooks().add(robBooks);
        ericBooks.getAuthors().add(rob);

        authorReposity.save(rob);
        bookRepository.save(robBooks);


    }
}
