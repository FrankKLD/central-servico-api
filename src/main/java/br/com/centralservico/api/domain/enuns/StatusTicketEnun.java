package br.com.centralservico.api.domain.enuns;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum StatusTicketEnun {
    OPEN("Ticket Aberto", 1),
    REOPENED("Ticket Reaberto", 2),
    IN_PROGRESS("Ticket Em Andamento", 3),
    CLOSED("Ticket Fechado", 4),
    CANCELED("Ticket Cancelado", 5),
    NOT_FINDED("Ticket Não Encontrado", 0);

    private final String description;

    private final Integer value;

    StatusTicketEnun(String description, int value) {
        this.description = description;
        this.value = value;
    }

    public static StatusTicketEnun getDescByValue(Integer value) {
        return Arrays.stream(StatusTicketEnun.values()).filter(enumRole -> enumRole.value.equals(value)).findFirst()
            .orElse(NOT_FINDED);
    }
}
