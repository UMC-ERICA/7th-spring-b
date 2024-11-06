package com.umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.umc.spring.domain.Store;
import com.umc.spring.repository.StoreRepository.StoreRepository;

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
	public List<Store> findStoresByNameAndScore(String name, String address) {
		List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, address);

		filteredStores.forEach(store -> System.out.println("Address: " + address));

		return filteredStores;
	}
}

