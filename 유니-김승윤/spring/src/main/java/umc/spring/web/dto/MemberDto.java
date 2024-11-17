package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberDto {
    
    @Getter
    public static class JoinDTO {
        
        private String password;
        private String name;
        private Integer gender;
        private LocalDate birthday;
        private String address;
        private String phone;
        private String email;
        private List<Long> preferCategory;
    }
    
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO{
        Long memberId;
        LocalDateTime createdAt;
    }
    
    public static class MemberProfileDto {
        private String nickname;
        private String email;
        private Integer point;
    }
}
