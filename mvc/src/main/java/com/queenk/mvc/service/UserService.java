package com.queenk.mvc.service;

import com.queenk.mvc.entity.User;
import com.queenk.mvc.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
    public User findById(Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
     }
    public User save(User user) {
        return repository.save(user);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
    public String count() {
        Long count = repository.count();
        String result = "จำนวนทั้งหมด "+count+" คน";
        return result;
    }
}
