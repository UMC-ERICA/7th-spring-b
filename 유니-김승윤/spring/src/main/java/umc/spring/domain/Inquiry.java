package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.base.BaseEntity;
import umc.spring.domain.enums.InquiryStatus;
import umc.spring.domain.enums.InquiryType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Inquiry extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String title;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(50)")
    private InquiryType type;
    
    @Column(nullable = false, columnDefinition = "text")
    private String content;
    
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(50) default 'PENDING' not null")
    private InquiryStatus status;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    
    @Builder.Default
    @OneToMany(mappedBy = "inquiry", cascade = CascadeType.ALL)
    private List<InquiryImageSave> images = new ArrayList<>();
}
