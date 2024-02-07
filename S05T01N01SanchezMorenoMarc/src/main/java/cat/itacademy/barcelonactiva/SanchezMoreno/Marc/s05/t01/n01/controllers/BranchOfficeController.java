package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t01.n01.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t01.n01.domain.BranchOffice;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t01.n01.dto.BranchOfficeDTO;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t01.n01.services.BranchOfficeService;


@Controller
@CrossOrigin(origins = "http://localhost:9000")
public class BranchOfficeController {
	
	@Autowired
	private BranchOfficeService branchOfficeService;

	@GetMapping("/sucursal/getAll")
	public String listAllBranchOffice(Model model) {
		
		List<BranchOfficeDTO> branchOfficeList = branchOfficeService.getAllBranchOffice();
		
		model.addAttribute("title","Branch office list");
		model.addAttribute("branchoffices",branchOfficeList);
		

		return "/views/branchoffices/list";
		
	}

    @GetMapping ("/sucursal/add")
    
    public String showRequestBranchOffice( Model model){
    	
        BranchOffice branchOffice = new BranchOffice();
        model.addAttribute("branchOffice", branchOffice);
        
        return "/views/branchoffices/add";
    }
    
    @PostMapping("/save")
    public String addbranchOffice(@ModelAttribute BranchOffice branchOffice){
    	
    	branchOfficeService.addBranchOffice(branchOffice);
    	    
        
        return "redirect:/sucursal/getAll";
    }
    
	@GetMapping("/sucursal/update/{id}")
	public String updateShowBranchOffice(@PathVariable("id") int id, Model model) {
				
		BranchOffice branchOffice = branchOfficeService.getOneBranchOffice(id);
		
		model.addAttribute("branchOfficeDTO",branchOffice);	

		return "/views/branchoffices/update";
		
	}
	
    @PostMapping("/update")
    public String updateBranchOffice(@ModelAttribute BranchOffice branchOffice){
    	
    	branchOfficeService.updateBranchOffice(branchOffice);
    	         
        return "redirect:/sucursal/getAll";
    }
    
    @GetMapping("/sucursal/getOne")
    public String getBranchOffice(@RequestParam("id") int id, Model model) {
        
        BranchOffice branchOffice = branchOfficeService.getOneBranchOffice(id);
        BranchOfficeDTO branchOfficeDTO = branchOfficeService.branchOfficeToDTO(branchOffice);
        model.addAttribute("branchOfficeDTO", branchOfficeDTO);

        return "/views/branchoffices/show";
    }

	@GetMapping("/sucursal/delete/{id}")
	public String deleteBranchOffice(@PathVariable("id") int id) {
		
		branchOfficeService.deleteBranchOffice(id);

		return "redirect:/sucursal/getAll";

	}
}
