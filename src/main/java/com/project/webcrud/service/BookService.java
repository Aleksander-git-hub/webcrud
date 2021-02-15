package com.project.webcrud.service;

import com.project.webcrud.dto.BookDto;
import com.project.webcrud.entity.BookEntity;
import com.project.webcrud.exceptions.NotFoundException;
import com.project.webcrud.mapper.BookMapper;
import com.project.webcrud.repository.BookRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public BookEntity saveBook(BookDto bookDto) {
        if (StringUtils.isEmpty(bookDto.getTitle()) ||
            bookDto.getPrice() == null) {
            throw new NotFoundException("Fields are empty!Please, check this!");
        }
        return bookRepository.save(bookMapper.toEntity(bookDto));
    }

    @Transactional
    public BookEntity getBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException("Book not found with id: " + bookId));
    }

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public BookEntity updateBookById(BookDto bookDto, Long bookId) {
        BookEntity existingBook = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException("Book not found with id: " + bookId));
        if (StringUtils.isEmpty(bookDto.getTitle()) ||
            bookDto.getPrice() == null) {
            throw new NotFoundException("Fields are empty!Please, check this!");
        } else {
            existingBook.setTitle(bookDto.getTitle());
            existingBook.setPrice(bookDto.getPrice());
        }
        return existingBook;
    }

    public void deleteBookById(Long bookId) {
        BookEntity existingBook = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException("Book not found with id: " + bookId));
        existingBook.setDeleted(true);
        bookRepository.save(existingBook);
    }
}
