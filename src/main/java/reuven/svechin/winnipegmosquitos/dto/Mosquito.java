package reuven.svechin.winnipegmosquitos.dto;

import lombok.*;
import reuven.svechin.winnipegmosquitos.enums.Sectors;

import javax.persistence.*;
import java.sql.Timestamp;

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
