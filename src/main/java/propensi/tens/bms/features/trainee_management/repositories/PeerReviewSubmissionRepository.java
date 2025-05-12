package propensi.tens.bms.features.trainee_management.repositories;

import java.util.List;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import propensi.tens.bms.features.trainee_management.models.PeerReviewAssignment;
import propensi.tens.bms.features.trainee_management.models.PeerReviewSubmission;

public interface PeerReviewSubmissionRepository extends JpaRepository<PeerReviewSubmission, Integer> {
    List<PeerReviewSubmission> findByAssignmentReviewerUsername(String reviewerUsername);
    List<PeerReviewSubmission> findByAssignmentRevieweeUsername(String revieweeUsername);

    List<PeerReviewSubmission> findByReviewedAtBetween(Date startDate, Date endDate);
    PeerReviewSubmission findByAssignment(PeerReviewAssignment assignment);
}
