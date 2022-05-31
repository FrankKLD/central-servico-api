package br.com.centralservico.api.controller;

import br.com.centralservico.api.domain.model.Classification;
import br.com.centralservico.api.domain.model.Level;
import br.com.centralservico.api.service.ClassificationService;
import br.com.centralservico.api.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/api/classification")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClassificationController {

    private final ClassificationService service;

    @GetMapping()
    public ResponseEntity<Optional<List<Classification>>> findAll() {
        Optional<List<Classification>> classification = service.findAll();
        if (classification.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(classification);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

}
