package com.project.webcrud.controller;

import com.project.webcrud.dto.BookDto;
import com.project.webcrud.entity.BookEntity;
import com.project.webcrud.mapper.BookMapper;
import com.project.webcrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @PostMapping(value = "/book")
    public BookDto saveBook(@RequestBody BookDto bookDto) {
        return bookMapper.toDto(bookService.saveBook(bookDto));
    }

    @GetMapping(value = "/book/{bookId}")
    public BookDto getBookById(@PathVariable(value = "bookId") Long bookId) {
        return bookMapper.toDto(bookService.getBookById(bookId));
    }

    @GetMapping(value = "/books")
    public List<BookDto> getAllBooks() {
        List<BookEntity> books = bookService.getAllBooks();
        return books.stream().map(bookMapper::toDto).collect(Collectors.toList());
    }

    @PutMapping(value = "/book/{bookId}")
    public BookDto updateBookById(@RequestBody BookDto bookDto,
                                  @PathVariable(value = "bookId") Long bookId) {
        return bookMapper.toDto(bookService.updateBookById(bookDto, bookId));
    }

    @DeleteMapping(value = "/book/{bookId}")
    public ResponseEntity<?> deleteBookById(@PathVariable(value = "bookId") Long bookId) {
        return bookService.deleteBookById(bookId);
    }
}
