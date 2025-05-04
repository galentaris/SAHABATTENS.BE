package propensi.tens.bms.features.shift_management.shift.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import propensi.tens.bms.features.account_management.models.Outlet;
import propensi.tens.bms.features.account_management.repositories.OutletDb;
import propensi.tens.bms.features.account_management.repositories.EndUserDb;
import propensi.tens.bms.features.shift_management.shift.dto.response.ShiftDashboardResponseDTO;
import propensi.tens.bms.features.shift_management.shift.models.ShiftSchedule;
import propensi.tens.bms.features.shift_management.shift.repositories.ShiftScheduleRepository;
import propensi.tens.bms.features.shift_management.shift.services.ShiftDashboardService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


@Service
@Transactional
public class ShiftDashboardServiceImpl implements ShiftDashboardService {

    @Autowired
    private OutletDb outletDb;

    @Autowired
    private EndUserDb endUserDb;

    @Autowired
    private ShiftScheduleRepository shiftRepo;

//     @Override
//     public ShiftDashboardResponseDTO getDashboardData() {
//         int totalOutlets = (int) outletDb.count();
//         int totalEmployees = (int) endUserDb.count();
//         int activeShifts = shiftRepo.findByDateShift(LocalDate.now()).size();

//         Map<Integer, Long> shiftTypeCount = shiftRepo.findByDateShift(LocalDate.now())
//                 .stream()
//                 .collect(Collectors.groupingBy(ShiftSchedule::getShiftType, Collectors.counting()));

//         int openingCount = shiftTypeCount.getOrDefault(1, 0L).intValue();
//         int closingCount = shiftTypeCount.getOrDefault(2, 0L).intValue();

//         List<ShiftDashboardResponseDTO.ShiftTypeDTO> shiftTypes = Arrays.asList(
//                 new ShiftDashboardResponseDTO.ShiftTypeDTO("Opening", openingCount),
//                 new ShiftDashboardResponseDTO.ShiftTypeDTO("Closing", closingCount)
//         );

//         int shiftTypesTotal = openingCount + closingCount;

//         List<ShiftDashboardResponseDTO.OutletCountDTO> outletCounts = outletDb.findAll().stream()
//                 .map(outlet -> new ShiftDashboardResponseDTO.OutletCountDTO(
//                         outlet.getName(),
//                         outlet.getListBarista() != null ? outlet.getListBarista().size() : 0
//                 )).collect(Collectors.toList());

//         return new ShiftDashboardResponseDTO(
//                 totalOutlets,
//                 totalEmployees,
//                 activeShifts,
//                 shiftTypesTotal,
//                 outletCounts,
//                 shiftTypes
//         );
//     }

        @Override
        public ShiftDashboardResponseDTO getDashboardData() {
                int totalOutlets = (int) outletDb.count();
                int totalEmployees = (int) endUserDb.count();

                List<ShiftSchedule> todayShifts = shiftRepo.findByDateShift(LocalDate.now()).stream()
                        .filter(shift -> shift.getDeletedAt() == null)
                        .toList();

                int activeShifts = todayShifts.size();

                Map<Integer, Long> shiftTypeCount = todayShifts.stream()
                        .collect(Collectors.groupingBy(ShiftSchedule::getShiftType, Collectors.counting()));

                int openingCount = shiftTypeCount.getOrDefault(1, 0L).intValue();
                int closingCount = shiftTypeCount.getOrDefault(2, 0L).intValue();

                List<ShiftDashboardResponseDTO.ShiftTypeDTO> shiftTypes = Arrays.asList(
                        new ShiftDashboardResponseDTO.ShiftTypeDTO("Opening", openingCount),
                        new ShiftDashboardResponseDTO.ShiftTypeDTO("Closing", closingCount)
                );

                int shiftTypesTotal = openingCount + closingCount;

                List<ShiftDashboardResponseDTO.OutletCountDTO> outletCounts = outletDb.findAll().stream()
                        .map(outlet -> new ShiftDashboardResponseDTO.OutletCountDTO(
                                outlet.getName(),
                                outlet.getListBarista() != null ? outlet.getListBarista().size() : 0
                        )).collect(Collectors.toList());

                return new ShiftDashboardResponseDTO(
                        totalOutlets,
                        totalEmployees,
                        activeShifts,
                        shiftTypesTotal,
                        outletCounts,
                        shiftTypes
                );
        }

        @Override
        public void deleteShiftById(Long id) {
        Optional<ShiftSchedule> shiftOpt = shiftRepo.findById(id);
        shiftOpt.ifPresent(shift -> {
                shift.setDeletedAt(LocalDateTime.now());
                shiftRepo.save(shift);
        });
        }

       
}
