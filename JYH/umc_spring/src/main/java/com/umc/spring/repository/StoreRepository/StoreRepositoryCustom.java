package com.umc.spring.repository.StoreRepository;

import java.util.List;

import com.umc.spring.domain.Store;

public interface StoreRepositoryCustom {
	List<Store> dynamicQueryWithBooleanBuilder(String name, String address);
}
