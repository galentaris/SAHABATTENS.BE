package propensi.tens.bms.features.shift_management.overtime.services;



import propensi.tens.bms.features.account_management.models.Outlet;
import propensi.tens.bms.features.account_management.repositories.OutletDb;
import propensi.tens.bms.features.shift_management.overtime.dto.request.OvertimeLogApprovalRequest;
import propensi.tens.bms.features.shift_management.overtime.dto.request.OvertimeLogRequest;
import propensi.tens.bms.features.shift_management.overtime.dto.request.OvertimeLogStatusRequest;
import propensi.tens.bms.features.shift_management.overtime.dto.response.OvertimeLogResponse;
import propensi.tens.bms.features.shift_management.overtime.models.OvertimeLog;
import propensi.tens.bms.features.shift_management.overtime.repositories.OvertimeLogDb;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;


public interface OvertimeLogService {
    public List<OvertimeLogResponse> getAllOvertimeLogs(String status, String sort, LocalDate startDate, LocalDate endDate);
    public List<OvertimeLogResponse> getOvertimeLogsByBarista(Integer baristaId);
    public List<OvertimeLogResponse> getOvertimeLogsByUser(UUID userId);
    public OvertimeLogResponse getOvertimeLogById(Integer id);
    public OvertimeLogResponse createOvertimeLog(OvertimeLogRequest request);
    public OvertimeLogResponse getOvertimeLogDetail(Integer id);
    public OvertimeLogResponse updateOvertimeLogStatus(Integer id, OvertimeLogStatusRequest request);
    public String getOutletName(Integer outletId);
    public OvertimeLogResponse approveOvertimeLog(Integer id, OvertimeLogApprovalRequest request);
    public String getBaristaName(Integer baristaId);
}
