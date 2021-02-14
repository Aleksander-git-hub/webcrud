package com.project.webcrud.service;

import com.project.webcrud.dto.UserDto;
import com.project.webcrud.entity.BookEntity;
import com.project.webcrud.entity.UserEntity;
import com.project.webcrud.exceptions.AlreadyAssignedException;
import com.project.webcrud.exceptions.NotFoundException;
import com.project.webcrud.mapper.UserMapper;
import com.project.webcrud.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserMapper userMapper;

    public UserEntity saveUser(UserDto userDto) {
        if (StringUtils.isEmpty(userDto.getFirstName()) ||
            StringUtils.isEmpty(userDto.getSecondName()) ||
            StringUtils.isEmpty(userDto.getEmail())) {
            throw new NotFoundException("Fields are empty!Please, check this!");
        }
        return userRepository.save(userMapper.toEntity(userDto));
    }

    public UserEntity getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + userId));
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public UserEntity updateUserById(UserDto userDto, Long userId) {
        UserEntity existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + userId));
        if (StringUtils.isEmpty(userDto.getFirstName()) ||
            StringUtils.isEmpty(userDto.getSecondName()) ||
            StringUtils.isEmpty(userDto.getEmail())) {
            throw new NotFoundException("Fields are empty!Please, check this!");
        } else {
            existingUser.setFirstName(userDto.getFirstName());
            existingUser.setSecondName(userDto.getSecondName());
            existingUser.setEmail(userDto.getEmail());
            existingUser.setAge(userDto.getAge());
            //existingUser.setBooks(userMapper.toEntity(userDto).getBooks());
        }
        return existingUser;
    }

    public ResponseEntity<?> deleteUserById(Long userId) {
        UserEntity existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + userId));
        existingUser.setDeleted(true);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public UserEntity addBookToUser(Long userId, Long bookId) {
        UserEntity existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + userId));
        BookEntity bookEntity = bookService.getBookById(bookId);
        if(Objects.nonNull(bookEntity.getUser())){
            throw new AlreadyAssignedException("Already assigned");
        }
        existingUser.getBooks().add(bookEntity);
        bookEntity.setUser(existingUser);
        return existingUser;
    }

    @Transactional
    public UserEntity removeBookFromUser(Long userId, Long bookId) {
        UserEntity existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + userId));
        BookEntity bookEntity = bookService.getBookById(bookId);
        existingUser.getBooks().remove(bookEntity);
        bookEntity.setUser(null);
        return existingUser;
    }
}
