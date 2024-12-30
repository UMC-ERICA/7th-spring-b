package umc.spring.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import umc.spring.domain.enums.Role;
import umc.spring.validation.annotation.ExistCategories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberDTO {
    
    @Getter
    @Setter
    public static class memberJoinDTO {
        @NotBlank
        private String password;
        @NotBlank
        private String name;
        @NotNull
        private Integer gender;
        @NotNull
        private LocalDate birthday;
        @Size(min = 5, max = 12)
        private String address;
        private String phone;
        @Email
        private String email;
        @ExistCategories
        private List<Long> preferCategory;
        @NotNull
        private Role role;
    }
    
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO{
        private Long memberId;
        private LocalDateTime createdAt;
    }
    
    public static class MemberProfileDTO {
        private String nickname;
        private String email;
        private Integer point;
    }
    
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionListDTO {
        private List<MemberMissionDTO> missionList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }
    
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionDTO {
        private String uuid;
        private String status;
        private LocalDateTime deadline;
        private String missionPrice;
        private int point;
    }
}