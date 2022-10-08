package br.com.centralservico.api.controller;

import br.com.centralservico.api.domain.model.Area;
import br.com.centralservico.api.service.AreaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/api/area")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class AreaController {

    private final AreaService service;

    @GetMapping
    public ResponseEntity<Optional<List<Area>>> findAll() {
        log.info("Testando Log em " + LocalDateTime.now());
        Optional<List<Area>> area = service.findAll();

        if (area.isPresent()) {
            log.info("Finalizado Log em " + LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.OK).body(area);
        } else {
            log.warn("Finalizado Log em " + LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @GetMapping("/{idArea}")
    public ResponseEntity<Optional<Area>> findOne(@PathVariable Long idArea) {
        log.info("Pesquisando pelo Id: " + idArea);
        Optional<Area> area = service.findOne(idArea);

        if (area.isPresent()) {
            log.info("Finalizado Log em " + LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.OK).body(area);
        } else {
            log.warn("Finalizado Log em " + LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

}
