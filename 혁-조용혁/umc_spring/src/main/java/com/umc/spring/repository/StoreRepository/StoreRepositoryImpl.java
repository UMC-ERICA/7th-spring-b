package com.umc.spring.repository.StoreRepository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.spring.domain.Store;
import com.umc.spring.domain.QStore;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom{
	private final JPAQueryFactory jpaQueryFactory;
	private final QStore store = QStore.store;

	@Override
	public List<Store> dynamicQueryWithBooleanBuilder(String name, String address) {
		BooleanBuilder predicate = new BooleanBuilder();

		if (name != null) {
			predicate.and(store.name.eq(name));
		}

		if (address != null) {
			predicate.and(store.address.eq(address));
		}

		return jpaQueryFactory
				.selectFrom(store)
				.where(predicate)
				.fetch();
	}
}
