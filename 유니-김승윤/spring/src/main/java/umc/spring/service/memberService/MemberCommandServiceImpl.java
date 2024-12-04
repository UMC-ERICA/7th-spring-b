package umc.spring.service.memberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodTypeHandler;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.FoodType;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.SelectFoodType;
import umc.spring.repository.FoodTypeRepository;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.web.dto.MemberDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{
    
    private final MemberRepository memberRepository;
    private final FoodTypeRepository foodTypeRepository;
    
    
    @Override
    @Transactional
    public Member joinMember(MemberDTO.memberJoinDTO request) {
        
        Member newMember = MemberConverter.toMember(request);
        
        List<FoodType> foodTypeList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodTypeRepository.findById(category).orElseThrow(() -> new FoodTypeHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());
        
        List<SelectFoodType> selectFoodTypeList = MemberConverter.toMemberPreferList(foodTypeList);
        
        selectFoodTypeList.forEach(selectFoodType -> {selectFoodType.setMember(newMember);});
        
        return memberRepository.save(newMember);
    }
}
