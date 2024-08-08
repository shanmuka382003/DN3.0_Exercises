package com.library;

import org.springframework.context.ApplicationContext; // Represents Inversion of Control and manages lifecycle of beans
import org.springframework.context.support.ClassPathXmlApplicationContext; // Loads the context configuration from an XML file located in classpath.
import com.library.service.BookService;
import com.library.repository.BookRepository;

public class MainApp {
    public static void main(String[] args) {
        // Load Spring context from XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get beans from the context
        BookService bookService = (BookService) context.getBean("bookService");
        BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");

        // Call methods to test the configuration
        bookService.displayBooks();
        System.out.println("BookService bean: " + bookService);
        System.out.println("BookRepository bean: " + bookRepository);
    }
}


