package br.com.centralservico.api.service;

import br.com.centralservico.api.domain.dto.TicketDto;
import br.com.centralservico.api.domain.enuns.StatusTicketEnun;
import br.com.centralservico.api.domain.model.Ticket;
import br.com.centralservico.api.persistence.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TicketService {

    private final TicketRepository repository;

    public Page<TicketDto> findAll(Integer status, int page, int size) {
        Page<Ticket> tickets;
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "id");

        if(status == 0) {
            tickets = new PageImpl<>(repository.findAll(), pageRequest, size);
        } else {
            tickets = new PageImpl<>(repository.findAllByStatus(status), pageRequest, size);
        }

        return tickets.map(new Function<Ticket, TicketDto>() {
            @Override
            public TicketDto apply(Ticket ticket) {
                String descStatus = StatusTicketEnun.getDescByValue(ticket.getStatus()).getDescription();

                return TicketDto.builder().ticketId(ticket.getId()).status(ticket.getStatus()).descStatus(descStatus)
                    .title(ticket.getTitle()).openBy(ticket.getOpenBy()).dateStart(ticket.getDateStart())
                    .dateEnd(ticket.getDateEnd()).dateUpdated(ticket.getDateUpdated()).priority(ticket.getPriority())
                    .responsibleUser(ticket.getResponsibleUser()).onTime(isOnTime(ticket.getDateEnd())).build();
            }
        });
    }

    private Boolean isOnTime(String dateEnd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime newDateEnd = LocalDateTime.parse(dateEnd, formatter);
        LocalDateTime now = LocalDateTime.now();

        return newDateEnd.isAfter(now);
    }

}
