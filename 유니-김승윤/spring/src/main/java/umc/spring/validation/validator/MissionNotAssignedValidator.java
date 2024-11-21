package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.service.missionService.MemberMissionServiceImpl;
import umc.spring.validation.annotation.MissionNotAssigned;

@Component
@RequiredArgsConstructor
public class MissionNotAssignedValidator implements ConstraintValidator<MissionNotAssigned, Long> {

    private final MemberMissionServiceImpl memberMissionService;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        if (missionId == null) {
            return true; // null 값은 검증하지 않음
        }

        // MemberMissionService를 통해 검증
        boolean isNotAssigned = !memberMissionService.isMissionAssignedToMember(missionId);
        if (!isNotAssigned) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Mission with ID " + missionId + " is already assigned.")
                    .addConstraintViolation();
        }

        return isNotAssigned;
    }
}