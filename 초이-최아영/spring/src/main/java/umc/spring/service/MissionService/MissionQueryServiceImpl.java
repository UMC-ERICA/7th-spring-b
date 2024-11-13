package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.web.dto.MissionStatusDto;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public List<MissionStatusDto> findProgressingMissions(Long memberId) {

        List<MissionStatusDto> filteredMissions = missionRepository.findProgressingMissionsByMemberId(memberId);

        filteredMissions.forEach(mission -> System.out.println("Mission: " + mission));

        return filteredMissions;
    }

    @Override
    public List<MissionStatusDto> findCompletedMissions(Long memberId) {

        List<MissionStatusDto> filteredMissions = missionRepository.findCompletedMissionsByMemberId(memberId);

        filteredMissions.forEach(mission -> System.out.println("Mission: " + mission));

        return filteredMissions;
    }

    @Override
    public List<Mission> findAvailableMissions(Long memberId) {

        List<Mission> filteredMissions = missionRepository.findAvailableMissionsByMemberId(memberId);

        filteredMissions.forEach(mission -> System.out.println("Mission: " + mission));

        return filteredMissions;
    }

}
