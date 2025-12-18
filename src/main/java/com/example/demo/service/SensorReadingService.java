@Service
public class SensorReadingService {

    private final SensorReadingRepository readingRepo;
    private final SensorRepository sensorRepo;

    public SensorReadingService(SensorReadingRepository readingRepo,
                                SensorRepository sensorRepo) {
        this.readingRepo = readingRepo;
        this.sensorRepo = sensorRepo;
    }

    public SensorReading submitReading(Long sensorId, SensorReading reading) {
        if (reading.getReadingValue() == null)
            throw new IllegalArgumentException("readingvalue");

        if (reading.getReadingTime().isAfter(java.time.LocalDateTime.now()))
            throw new IllegalArgumentException("future");

        Sensor sensor = sensorRepo.findById(sensorId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        reading.setSensor(sensor);
        return readingRepo.save(reading);
    }
}
