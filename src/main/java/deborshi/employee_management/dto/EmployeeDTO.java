package deborshi.employee_management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 1, max = 255)
    private  String name;

    @NotBlank(message = "Email cannot blank")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Salary cannot be empty")
    @Positive
    private BigDecimal salary;

    @NotNull(message = "Date of birth cannot be null")
    @Past(message = "Date of birth can not be present or future date")
    private LocalDate dob;
}
