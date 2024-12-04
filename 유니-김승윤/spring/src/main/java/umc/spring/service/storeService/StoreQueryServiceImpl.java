package umc.spring.service.storeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Store;
import umc.spring.repository.StoreRepository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{
    
    private final StoreRepository storeRepository;
    
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
}
