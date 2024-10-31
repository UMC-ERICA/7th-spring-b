package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;

import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.FavCategory;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 15)
    private String title;

}
