package umc.spring.service.RegionService;

import umc.spring.domain.Region;

import java.util.Optional;

public interface RegionService {
    Optional<Region> findRegion(Long id);
}
