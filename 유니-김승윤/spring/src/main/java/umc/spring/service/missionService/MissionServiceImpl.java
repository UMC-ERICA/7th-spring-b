package umc.spring.service.missionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.MissionDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionServiceImpl implements MissionService {
    
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    
    public void createMission(MissionDTO.CreateMissionRequestDTO req) {
        
        Store findStore = storeRepository.findById(req.getStoreId()).orElseThrow(
                () -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND)
        );
        Mission newMission = MissionConverter.toMission(req);
        newMission.setStore(findStore);
        
        missionRepository.save(newMission);
    }
}
