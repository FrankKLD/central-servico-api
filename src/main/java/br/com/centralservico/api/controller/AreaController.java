package br.com.centralservico.api.controller;

import br.com.centralservico.api.domain.model.Area;
import br.com.centralservico.api.service.AreaService;
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
@RequestMapping("/api/area")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AreaController {

    private final AreaService service;

    @GetMapping
    public ResponseEntity<Optional<List<Area>>> findAll() {
        Optional<List<Area>> area = service.findAll();

        if (area.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(area);
        } else {

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

}
