package com.dio.clockIn.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class BankedHours {
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class IdBankedHours implements Serializable {
        private long idBankedHours;
        private long idMovement;
        private long idUser;
    }
    //Indica a chave composta:
    @EmbeddedId
    private IdBankedHours id;
    private LocalDateTime workedDay;
    private BigDecimal hoursWorked;
    private BigDecimal hoursBalance;
}