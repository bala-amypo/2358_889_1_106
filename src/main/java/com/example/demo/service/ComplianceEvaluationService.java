// @Service
// public class ComplianceEvaluationService {

//     private final SensorReadingRepository readingRepo;
//     private final ComplianceThresholdRepository thresholdRepo;
//     private final ComplianceLogRepository logRepo;

//     public ComplianceEvaluationService(
//         SensorReadingRepository readingRepo,
//         ComplianceThresholdRepository thresholdRepo,
//         ComplianceLogRepository logRepo) {

//         this.readingRepo = readingRepo;
//         this.thresholdRepo = thresholdRepo;
//         this.logRepo = logRepo;
//     }

//     public ComplianceLog evaluateReading(Long readingId) {

//         SensorReading reading = readingRepo.findById(readingId)
//                 .orElseThrow(() -> new ResourceNotFoundException("not found"));

//         ComplianceThreshold t = thresholdRepo
//                 .findBySensorType(reading.getSensor().getSensorType())
//                 .orElseThrow(() -> new ResourceNotFoundException("not found"));

//         String status = (reading.getReadingValue() >= t.getMinValue()
//                 && reading.getReadingValue() <= t.getMaxValue())
//                 ? "COMPLIANT" : "NON_COMPLIANT";

//         reading.setStatus(status);

//         ComplianceLog log = new ComplianceLog();
//         log.setSensorReading(reading);
//         log.setThresholdUsed(t);
//         log.setStatusAssigned(status);

//         return logRepo.save(log);
//     }
// }
