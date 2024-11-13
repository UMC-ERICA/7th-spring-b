package umc.spring.apiPayload;

public interface BaseErrorCode {
    
    ErrorReasonDTO getReason();
    
    ErrorReasonDTO getReasonHttpStatus();
}
