package com.dio.clockIn.model;

import lombok.*;

import javax.persistence.*;
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
public class Movement {
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class IdMovement implements Serializable {
        private Long idMovement;
        private Long idUsuer;
    }
    //Indica a chave composta:
    @EmbeddedId
    private IdMovement id;
    private LocalDateTime inDate;
    private LocalDateTime outDate;
    private BigDecimal time;
    @ManyToOne
    private Event event;
    @ManyToOne
    private Calendar calendar;
}
