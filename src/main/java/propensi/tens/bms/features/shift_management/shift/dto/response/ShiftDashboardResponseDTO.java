package propensi.tens.bms.features.shift_management.shift.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShiftDashboardResponseDTO {
    private int totalOutlets;
    private int totalEmployees;
    private int activeShifts;
    private int shiftTypes;
    private List<OutletCountDTO> staffByOutlet;
    private List<ShiftTypeDTO> shiftTypeDistribution;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OutletCountDTO {
        private String outlet;
        private int count;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ShiftTypeDTO {
        private String type;
        private int count;
    }
}