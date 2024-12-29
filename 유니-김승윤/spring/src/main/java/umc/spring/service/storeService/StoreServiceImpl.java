package umc.spring.service.storeService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.domain.Region;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.StoreResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreServiceImpl implements StoreService {
    
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final ReviewRepository reviewRepository;
    
    @Override
    public void addStoreToRegion(StoreResponseDTO.StoreToRegion req) {
        
        Store findStore = storeRepository.findById(req.getStoreId()).orElseThrow(
                () -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND)
        );
        
        Region findRegion = regionRepository.findById(req.getRegionId()).orElseThrow(
                () -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND)
        );
        
        findStore.setRegion(findRegion);
        
        storeRepository.save(findStore);
    }
    
    @Override
    public boolean isStoreExists(Long storeId) {
        return storeRepository.existsById(storeId);
    }
    
    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {
        
        Store store = storeRepository.findById(StoreId).get();
        
        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        
        return StorePage;
    }
}