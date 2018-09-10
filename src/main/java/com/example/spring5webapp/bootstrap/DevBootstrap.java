package com.example.spring5webapp.bootstrap;

import com.example.spring5webapp.model.Author;
import com.example.spring5webapp.model.Book;
import com.example.spring5webapp.repositories.AuthorReposity;
import com.example.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorReposity authorReposity;
    private BookRepository bookRepository;


    public DevBootstrap(AuthorReposity authorReposity, BookRepository bookRepository) {
        this.authorReposity = authorReposity;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }


    private void initData() {

        //Eric
        Author eric = new Author("Eric", ">>>");
        Book ericBooks = new Book("","","");
        eric.getBooks().add(ericBooks);
        ericBooks.getAuthors().add(eric);

        authorReposity.save(eric);
        bookRepository.save(ericBooks);

        //Rob
        Author rob = new Author("Rob", "????");
        Book robBooks = new Book("","","");
        rob.getBooks().add(robBooks);
        ericBooks.getAuthors().add(rob);

        authorReposity.save(rob);
        bookRepository.save(robBooks);


    }
}
