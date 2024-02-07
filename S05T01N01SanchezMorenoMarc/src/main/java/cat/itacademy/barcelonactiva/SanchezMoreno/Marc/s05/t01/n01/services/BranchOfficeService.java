package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t01.n01.services;

import java.util.List;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t01.n01.domain.BranchOffice;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t01.n01.dto.BranchOfficeDTO;


public interface BranchOfficeService {
	public void addBranchOffice(BranchOffice branchOffice);

	public void updateBranchOffice(BranchOffice branchOffice);

	public void deleteBranchOffice(Integer id);

	public BranchOffice getOneBranchOffice(int id);

	public List<BranchOfficeDTO> getAllBranchOffice();

	public BranchOfficeDTO branchOfficeToDTO(BranchOffice branchOffice);
    
    public BranchOffice searchByName(String branchOfficeName);

}
