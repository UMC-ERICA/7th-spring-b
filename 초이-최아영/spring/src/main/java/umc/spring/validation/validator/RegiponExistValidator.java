package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.Region;
import umc.spring.service.RegionService.RegionService;
import umc.spring.validation.annotation.ExistRegion;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RegiponExistValidator implements ConstraintValidator<ExistRegion, Long> {

    private final RegionService regionService;

    @Override
    public void initialize(ExistRegion constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        Optional<Region> target = regionService.findRegion(value);

        if (target.isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REGION_NOT_FOUND.getMessage()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
