package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.base.BaseEntity;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.mapping.SelectFoodType;
import umc.spring.domain.mapping.UserMission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 50)
    private String userid;
    
    @Column(nullable = false, length = 50)
    private String password;
    
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
    
    @Column(nullable = false, length = 40)
    private String email;
    
    private int point;
    
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(15) default 'ACTIVE'")
    private MemberStatus status;
    
    private LocalDate inactiveDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "social_login_id")
    private SocialLogin socialLogin;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<SelectFoodType> selectFoodTypes = new ArrayList<>();
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Inquiry> inquiries = new ArrayList<>();
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> userMissions = new ArrayList<>();
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ProfileImageSave> images = new ArrayList<>();
    
}
