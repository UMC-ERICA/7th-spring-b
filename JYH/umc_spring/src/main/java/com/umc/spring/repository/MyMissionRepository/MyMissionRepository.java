package com.umc.spring.repository.MyMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umc.spring.domain.mapping.MyMission;

public interface MyMissionRepository extends JpaRepository<MyMission, Long>, MyMissionRepositoryCustom{
}
