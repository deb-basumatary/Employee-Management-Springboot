package deborshi.employee_management.advices;


import deborshi.employee_management.dto.ErrorResponseDTO;
import deborshi.employee_management.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Response<?>> handleResourceNotFound(ResourceNotFoundException exception){

        ErrorResponseDTO errorResponse = ErrorResponseDTO.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(HttpStatus.NOT_FOUND.getReasonPhrase())
                .detail(exception.getMessage())
                .build();
        return buildErrorResponseEntity(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<?>> handleInternalServerError(Exception exception){

        ErrorResponseDTO errorResponse = ErrorResponseDTO.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .detail(exception.getMessage())
                .build();
        return buildErrorResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Response<?>> handleBadRequest(IllegalArgumentException exception){

        ErrorResponseDTO errorResponse = ErrorResponseDTO.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .detail(exception.getMessage())
                .build();
        return buildErrorResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }


    private ResponseEntity<Response<?>> buildErrorResponseEntity(ErrorResponseDTO errorResponse, HttpStatus status) {
        return new ResponseEntity<>(new Response<>(errorResponse), status);
    }
}
