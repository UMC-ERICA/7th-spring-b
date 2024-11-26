package umc.spring.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.FoodType;
import umc.spring.domain.Member;
import umc.spring.domain.base.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SelectFoodType extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_type_id")
    private FoodType foodType;
    
    public void setMember(Member member){
        if(this.member != null)
            member.getSelectFoodTypes().remove(this);
        this.member = member;
        member.getSelectFoodTypes().add(this);
    }
    
    public void setFoodType(FoodType foodType){
        this.foodType = foodType;
    }
}
