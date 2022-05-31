package br.com.centralservico.api.service;

import br.com.centralservico.api.domain.model.Classification;
import br.com.centralservico.api.persistence.ClassificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClassificationService {

    private final ClassificationRepository repository;

    public Optional<List<Classification>> findAll() {
        return Optional.of(repository.findAll());
    }

}
