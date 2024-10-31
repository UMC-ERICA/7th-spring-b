package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;

import umc.spring.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 20)
    private String region;

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Question> questionList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

}
