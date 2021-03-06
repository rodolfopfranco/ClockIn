package com.dio.clockIn.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class Calendar {
    @Id
    private Long id;
    @ManyToOne
    private DateType dataType;
    private String descricao;
    private LocalDateTime specialDate;
}
