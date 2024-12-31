package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.spring.domain.base.BaseEntity;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.enums.Role;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.SelectFoodType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String password;
    
    @Enumerated(EnumType.STRING)
    private Role role;
    
    @Column(nullable = false, length = 10)
    private String name;
    
    @Column(nullable = true, length = 50)
    private String nickname;
    
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    private Gender gender;
    
    @Column(nullable = false)
    private LocalDate birthday;
    
    @Column(nullable = false, length = 50)
    private String address;
    
    @Column(nullable = false, length = 11)
    private String phone;
    
    @Column(nullable = true, length = 40)
    private String email;
    
    @ColumnDefault("0")
    private int point;
    
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(15) default 'ACTIVE'")
    private MemberStatus status;
    
    private LocalDate inactiveDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "social_login_id")
    private SocialLogin socialLogin;
    
    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<SelectFoodType> selectFoodTypes = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Inquiry> inquiries = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissions = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<ProfileImageSave> images = new ArrayList<>();
    
    public void encodePassword(String password) {
        this.password = password;
    }
}
