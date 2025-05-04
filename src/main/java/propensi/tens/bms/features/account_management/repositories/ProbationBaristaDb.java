package propensi.tens.bms.features.account_management.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import propensi.tens.bms.features.account_management.models.ProbationBarista;

import java.util.UUID;
import java.util.List;

@Repository
public interface ProbationBaristaDb extends JpaRepository<ProbationBarista, UUID>{
    List<ProbationBarista> findByOutlet_OutletId(Long outletId);
    List<ProbationBarista> findByOutlet_OutletIdAndStatusIgnoreCase(Long outletId, String status);
}
