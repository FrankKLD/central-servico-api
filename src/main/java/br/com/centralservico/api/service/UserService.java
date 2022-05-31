package br.com.centralservico.api.service;

import br.com.centralservico.api.domain.model.User;
import br.com.centralservico.api.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserRepository repository;

    public Optional<List<User>> findAll() {
        return Optional.of(repository.findAll());
    }

    public Optional<User> save(User user) {
        return Optional.of(repository.save(user));
    }

    public Optional<User> update(User user) {
        return Optional.of(repository.saveAndFlush(user));
    }

    public Optional<User> delete(User user) {
        Optional<User> currentUser = repository.findById(user.getId());

        if(currentUser.isPresent()) {
            repository.delete(user);
        }
        return currentUser;
    }

}
