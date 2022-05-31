package br.com.centralservico.api.controller;

import br.com.centralservico.api.domain.model.Level;
import br.com.centralservico.api.domain.model.User;
import br.com.centralservico.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService service;

    @GetMapping
    public ResponseEntity<Optional<List<User>>> findAll() {
        Optional<List<User>> user = service.findAll();

        if (user.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Optional<User>> save(@RequestBody User user) {
        Optional<User> userResponse = service.save(user);

        if (userResponse.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(userResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Optional<User>> update(@RequestBody User user) {
        Optional<User> userResponse = service.update(user);

        if (userResponse.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(userResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @DeleteMapping
    public ResponseEntity<Optional<User>> delete(@RequestBody User user) {
        Optional<User> userResponse = service.delete(user);

        if (userResponse.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(userResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
