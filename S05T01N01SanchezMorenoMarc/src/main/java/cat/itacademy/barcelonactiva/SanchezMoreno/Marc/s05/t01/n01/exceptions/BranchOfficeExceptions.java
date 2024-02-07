package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t01.n01.exceptions;
import jakarta.persistence.EntityNotFoundException;
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
}


