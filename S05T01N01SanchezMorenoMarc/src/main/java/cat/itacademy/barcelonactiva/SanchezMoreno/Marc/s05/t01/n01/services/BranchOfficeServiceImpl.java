package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t01.n01.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t01.n01.domain.BranchOffice;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t01.n01.dto.BranchOfficeDTO;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t01.n01.repository.BranchOfficeRepo;
import jakarta.persistence.EntityNotFoundException;

@Service
public class BranchOfficeServiceImpl implements BranchOfficeService {
	
	
	private BranchOfficeRepo branchOfficeRepo;
	
	  public BranchOfficeServiceImpl(BranchOfficeRepo branchOfficeRepo){
	        this.branchOfficeRepo = branchOfficeRepo;
	  }

	@Override
	public void addBranchOffice(BranchOffice branchOffice) {
		branchOfficeRepo.save(branchOffice);
		
	}

	@Override
	public void updateBranchOffice(BranchOffice branchOffice) {
		branchOfficeRepo.save(branchOffice);
		
	}

	@Override
	public void deleteBranchOffice(Integer id) {
		
	       Optional<BranchOffice> branchOffice = branchOfficeRepo.findById(id);
	        if(branchOffice.isPresent()){
	        	branchOfficeRepo.deleteById(id);
	        }
	        else{
	            throw new EntityNotFoundException();
	        }
	    }


	@Override
	public BranchOffice getOneBranchOffice(int id) {
		
        Optional<BranchOffice> branchOffice = branchOfficeRepo.findById(id);
        if(branchOffice.isPresent()){
            return branchOffice.get();
        }
        else {
            throw new EntityNotFoundException();
        }
    }

	@Override
	public List<BranchOfficeDTO> getAllBranchOffice() {
		
		List<BranchOfficeDTO> allBranchOfficeDTO = new ArrayList<>();
		
		branchOfficeRepo.findAll().forEach(b -> allBranchOfficeDTO.add(branchOfficeToDTO(b)));
				
		return allBranchOfficeDTO;

}


	@Override
	public BranchOfficeDTO branchOfficeToDTO(BranchOffice branchOffice) {
		
		return new BranchOfficeDTO(branchOffice);
	}

	@Override
	public BranchOffice searchByName(String branchOfficeName) {
		return branchOfficeRepo.searchByName(branchOfficeName);
	}

}
