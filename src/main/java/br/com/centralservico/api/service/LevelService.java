package br.com.centralservico.api.service;

import br.com.centralservico.api.domain.model.Level;
import br.com.centralservico.api.persistence.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LevelService {

    private final LevelRepository repository;

    public Optional<List<Level>> findAll() {
        return Optional.of(repository.findAll());
    }

}
