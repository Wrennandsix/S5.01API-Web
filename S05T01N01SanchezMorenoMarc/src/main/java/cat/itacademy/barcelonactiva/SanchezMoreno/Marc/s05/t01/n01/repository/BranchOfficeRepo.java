package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t01.n01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t01.n01.domain.BranchOffice;

@Repository
public interface BranchOfficeRepo extends JpaRepository<BranchOffice, Integer> {
	
	 public BranchOffice searchByName(String branchOfficeName);
}
