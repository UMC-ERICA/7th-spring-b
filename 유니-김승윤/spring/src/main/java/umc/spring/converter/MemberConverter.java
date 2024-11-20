package umc.spring.converter;

import umc.spring.domain.FoodType;
import umc.spring.domain.Member;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.mapping.SelectFoodType;
import umc.spring.web.dto.MemberDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {
    
    public static MemberDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    
    public static Member toMember(MemberDTO.memberJoinDTO request){
        
        Gender gender = null;
        
        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
        }
        
        return Member.builder()
                .password(request.getPassword())
                .address(request.getAddress())
                .gender(gender)
                .birthday(request.getBirthday())
                .name(request.getName())
                .selectFoodTypes(new ArrayList<>())
                .phone(request.getPhone())
                .build();
    }
    
    public static List<SelectFoodType> toMemberPreferList(List<FoodType> foodTypeList){
        
        return foodTypeList.stream()
                .map(foodType ->
                        SelectFoodType.builder()
                                .foodType(foodType)
                                .build()
                ).collect(Collectors.toList());
    }
}
