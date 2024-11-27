package umc.spring.service.storeService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.web.dto.StoreResponseDTO;

public interface StoreService {

    void addStoreToRegion(StoreResponseDTO.StoreToRegion req);
    
    boolean isStoreExists(Long storeId);
    
    Page<Review> getReviewList(Long StoreId, Integer page);
    
}
