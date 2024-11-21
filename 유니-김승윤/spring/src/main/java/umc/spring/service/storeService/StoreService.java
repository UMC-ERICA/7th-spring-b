package umc.spring.service.storeService;

import umc.spring.web.dto.StoreDTO;

public interface StoreService {

    void addStoreToRegion(StoreDTO.StoreToRegion req);
    
    boolean isStoreExists(Long storeId);
}
