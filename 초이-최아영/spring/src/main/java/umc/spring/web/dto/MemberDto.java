package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDto {

    private String name;
    private String email;
    private String phoneNum;
    private Integer point;

}
