package umc.spring.service.storeService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{
    
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    
    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }
    
    @Override
    public List<Store> findStoresByNameAndRating(String name, Float raring) {
        List<Store> filteredRatings = storeRepository.dynamicQueryWithBooleanBuilder(name, raring);
        
        filteredRatings.forEach(rating -> System.out.println("rating: " + rating));
        
        return filteredRatings;
    }
    
    @Override
    public Page<Mission> findMissionsByStore(Long storeId, Integer page) {
        
        Store findStore = storeRepository.findById(storeId).get();
        
        Page<Mission> storePage = missionRepository.findAllByStore(findStore, PageRequest.of(page, 10));
        
        return storePage;
    }
}
