package com.reuven.svechin.winnipegmosquitoes.dto;

import com.reuven.svechin.winnipegmosquitoes.enums.Sectors;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The class represents a record of local resource
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Mosquito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String trapid;
    private int mosquitoes;
    @Enumerated(EnumType.STRING)
    private Sectors sector;
    private Timestamp createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
