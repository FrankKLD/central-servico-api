package br.com.centralservico.api.controller;

import br.com.centralservico.api.domain.dto.TicketDto;
import br.com.centralservico.api.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api/ticket")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TicketController {

    private final TicketService service;

    @GetMapping
    public ResponseEntity<Page<TicketDto>> findAll(@RequestParam(value = "status", required = false, defaultValue = "0") Integer status,
                                                   @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                   @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        Page<TicketDto> level = service.findAll(status, page, size);

        return ResponseEntity.status(HttpStatus.OK).body(level);
    }

}
