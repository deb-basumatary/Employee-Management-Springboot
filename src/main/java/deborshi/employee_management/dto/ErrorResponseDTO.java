package deborshi.employee_management.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponseDTO {

    private int status;

//    private String correlationId;

    private String message;

    private String detail;

}
