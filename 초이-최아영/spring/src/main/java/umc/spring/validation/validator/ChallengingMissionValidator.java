package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MissionService.MemberMissionService;
import umc.spring.validation.annotation.ChallengingMission;
import umc.spring.web.dto.MemberRequestDTO;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ChallengingMissionValidator implements ConstraintValidator<ChallengingMission, MemberRequestDTO.ChallengeMissionDTO> {

    private final MemberMissionService memberMissionService;

    @Override
    public void initialize(ChallengingMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberRequestDTO.ChallengeMissionDTO request, ConstraintValidatorContext context) {

        Long memberId = request.getMemberId();
        Long missionId = request.getMissionId();

        Optional<MemberMission> target = memberMissionService.findMemberMission(memberId, missionId);

        if (!target.isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.CHALLENGING_MISSION.getMessage()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
