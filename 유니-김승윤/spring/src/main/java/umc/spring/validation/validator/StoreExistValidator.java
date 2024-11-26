package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.service.storeService.StoreService;
import umc.spring.validation.annotation.StoreExists;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<StoreExists, Long> {
    
    private final StoreService storeService; // 서비스 계층 의존
    
    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        if (storeId == null) {
            return true; // null 값은 검증하지 않음
        }
        
        // Store가 존재하는지 서비스에서 확인
        boolean exists = storeService.isStoreExists(storeId);
        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Store with ID " + storeId + " does not exist.")
                    .addConstraintViolation();
        }
        
        return exists;
    }
}
