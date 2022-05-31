package br.com.centralservico.api.controller;

import br.com.centralservico.api.domain.model.Level;
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
@RequestMapping("/api/level")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LevelController {

    private final LevelService service;

    @GetMapping()
    public ResponseEntity<Optional<List<Level>>> findAll() {
        Optional<List<Level>> level = service.findAll();
        if (level.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(level);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

}
