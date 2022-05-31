package br.com.centralservico.api.service;

import br.com.centralservico.api.domain.model.Area;
import br.com.centralservico.api.persistence.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AreaService {

    private final AreaRepository repository;

    public Optional<List<Area>> findAll() {
        return Optional.of((repository.findAll()));
    }

}
