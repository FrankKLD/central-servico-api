package br.com.centralservico.api.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Builder
@Entity
@Table(name = "TBL_TICKET")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DATE_START")
    private String dateStart;

    @Column(name = "DATE_END")
    private String dateEnd;

    @Column(name = "DATE_UPDATED")
    private String dateUpdated;

    @Column(name = "PRIORITY")
    private String priority;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_USER_OPEN_BY", nullable = true)
    private User openBy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_USER_RESPONSIBLE", nullable = true)
    private User responsibleUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_AREA", nullable = true)
    private Area area;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CLASSIFICATION", nullable = true)
    private Classification classification;

    @Column(name = "ENABLE")
    private boolean enable;

}
