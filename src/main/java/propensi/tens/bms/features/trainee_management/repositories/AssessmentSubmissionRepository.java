package propensi.tens.bms.features.trainee_management.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import propensi.tens.bms.features.trainee_management.dto.response.SubmissionSummaryDTO;
import propensi.tens.bms.features.trainee_management.models.AssessmentSubmission;
public interface AssessmentSubmissionRepository extends JpaRepository<AssessmentSubmission, Long> {
    @Query("""
        select new propensi.tens.bms.features.trainee_management.dto.response.SubmissionSummaryDTO(
          s.id,
          s.submittedAt,
          s.mcScore,
          s.essayScore,
          s.totalScore,
          s.essayReviewed,
          u.username
        )
        from AssessmentSubmission s
        join s.user u
       where s.assessment.id = :assessmentId
    """)
    List<SubmissionSummaryDTO> findSummariesByAssessmentId(@Param("assessmentId") Long assessmentId);
}
