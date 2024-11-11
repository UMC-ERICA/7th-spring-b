package com.umc.spring.service.StoreService;

import java.util.List;
import java.util.Optional;

import com.umc.spring.domain.Store;

public interface StoreQueryService {

	Optional<Store> findStore(Long id);
	List<Store> findStoresByNameAndAddress(String name, String address);
}