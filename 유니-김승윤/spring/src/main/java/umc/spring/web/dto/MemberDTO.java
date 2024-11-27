package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.ExistCategories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberDTO {
    
    @Getter
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
        private String email;
        @ExistCategories
        private List<Long> preferCategory;
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
}