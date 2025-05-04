package propensi.tens.bms.features.trainee_management.services;

import java.util.List;

import propensi.tens.bms.features.trainee_management.dto.request.CreateAssessmentRequest;
import propensi.tens.bms.features.trainee_management.dto.request.UpdateAssessmentRequest;
import propensi.tens.bms.features.trainee_management.dto.response.AssessmentResponse;

public interface AssessmentService {
    AssessmentResponse createAssessment(CreateAssessmentRequest request);
    List<AssessmentResponse> getAllAssessments();
    AssessmentResponse getAssessmentById(Long id);
    AssessmentResponse updateAssessment(Long id, UpdateAssessmentRequest request);
    void deleteAssessment(Long id);
    
    List<String> getAllBaristaUsernames();
    List<String> getAllHeadBarUsernames();
    List<String> getAllTraineeBaristaUsernames();
    List<AssessmentResponse> getAssessmentsByUserId(String username);
}
