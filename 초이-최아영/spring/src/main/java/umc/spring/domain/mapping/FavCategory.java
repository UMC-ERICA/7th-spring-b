package umc.spring.domain.mapping;

import jakarta.persistence.*;
import lombok.*;

import umc.spring.domain.Category;
import umc.spring.domain.Member;
import umc.spring.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FavCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public void setMember(Member member){
        if (this.member != null)
            member.getFavCategoryList().remove(this);
        this.member = member;
        member.getFavCategoryList().add(this);
    }

    public void setCategory(Category category){
        this.category = category;
    }

}
