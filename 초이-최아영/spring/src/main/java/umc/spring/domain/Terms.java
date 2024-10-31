package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;

import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.Agreement;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Terms extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String context;

    private Boolean optional;

    @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
    private List<Agreement> agreementList = new ArrayList<>();

}
