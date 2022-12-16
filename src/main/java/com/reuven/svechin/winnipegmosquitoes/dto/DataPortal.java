package com.reuven.svechin.winnipegmosquitoes.dto;

import com.reuven.svechin.winnipegmosquitoes.enums.Sectors;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DataPortal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String trapid;
    private int mosquitoes;
    @Enumerated(EnumType.STRING)
    private Sectors location;
    private Timestamp timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
