package com.sprta.samsike.domain.region;

import com.sprta.samsike.domain.Stamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Entity
@Table(catalog = "samsike", name = "p_sgg_code")
@Getter
@Setter
public class SggCode extends Stamped {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private UUID uuid;

    @Column(unique = true, length = 50, nullable = false)
    private String sggCd;

    @Column(nullable = false)
    private String sggCdNm;
}
