package umc.spring.service.storeService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {
    
    Optional<Store> findStore(Long id);
    
    List<Store> findStoresByNameAndRating(String name, Float score);
    
    Page<Mission> findMissionsByStore(Long storeId, Integer page);
}
