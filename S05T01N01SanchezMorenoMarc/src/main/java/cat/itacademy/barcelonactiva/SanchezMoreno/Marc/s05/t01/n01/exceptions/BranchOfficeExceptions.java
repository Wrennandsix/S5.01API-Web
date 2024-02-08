package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t01.n01.exceptions;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class BranchOfficeExceptions {
	
	
    @ExceptionHandler(EntityNotFoundException.class)
    public String handleNotFoundException(EntityNotFoundException ex, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("notFoundError", " Branch office not found!!");
        return "redirect:/sucursal/getAll";
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception ex, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("error", ex.getMessage());
        return "/views/branchoffices/exception";
    }
 
    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<String> handleInvalidInput(HttpMessageConversionException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect data type");
    }
}


