package deborshi.employee_management.advices;

import deborshi.employee_management.dto.ErrorResponseDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Response <T>{

    private LocalDateTime timeStamp;
    private T data;
    private ErrorResponseDTO error;

    public Response(){
        this.timeStamp = LocalDateTime.now();
    }

    public Response(T data){
        this();
        this.data = data;
    }
    public Response(ErrorResponseDTO error){
        this();
        this.error = error;
    }
}
