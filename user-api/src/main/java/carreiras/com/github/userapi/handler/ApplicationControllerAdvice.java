package carreiras.com.github.userapi.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import carreiras.com.github.userapi.exception.ResourceNotFoundException;

public class ApplicationControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiError handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        return new ApiError(resourceNotFoundException.getMessage());
    }
}
