package propensi.tens.bms.features.shift_management.shift.services;

import propensi.tens.bms.features.shift_management.shift.dto.response.ShiftDashboardResponseDTO;

public interface ShiftDashboardService {
    ShiftDashboardResponseDTO getDashboardData();

    void deleteShiftById(Long id);


}