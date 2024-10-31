package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

import umc.spring.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    private Integer rating;

    private LocalDate date;

    @Column(columnDefinition = "TEXT")
    private String context;

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

}
