package com.umc.spring.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.umc.spring.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}