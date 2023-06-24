package carreiras.com.github.userapi.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import carreiras.com.github.userapi.exception.ResourceNotFoundException;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ApiError handlerDataIntegrityViolationException(
            DataIntegrityViolationException dataIntegrityViolationException) {
        return new ApiError("O CPF informado é uma chave duplicada.");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiError handlerMethodArgumentNotValidException(
            MethodArgumentNotValidException methodArgumentNotValidException) {
        List<String> collectErrors = methodArgumentNotValidException.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
        return new ApiError(collectErrors);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiError handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        return new ApiError(resourceNotFoundException.getMessage());
    }
}
