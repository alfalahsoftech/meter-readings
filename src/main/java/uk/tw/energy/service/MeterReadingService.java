package uk.tw.energy.service;

import org.springframework.stereotype.Service;
import uk.tw.energy.domain.ElectricityReading;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class MeterReadingService {

    private final Map<String, List<ElectricityReading>> meterAssociatedReadings;

    public MeterReadingService(Map<String, List<ElectricityReading>> meterAssociatedReadings) {
        this.meterAssociatedReadings = meterAssociatedReadings;
    }

    public Optional<List<ElectricityReading>> getReadings(String smartMeterId) {
    	System.out.println("meterAssociatedReadings = " + meterAssociatedReadings);
        return Optional.ofNullable(meterAssociatedReadings.get(smartMeterId));
    }

    public void storeReadings(String smartMeterId, List<ElectricityReading> electricityReadings) {
        if (!meterAssociatedReadings.containsKey(smartMeterId)) {
            meterAssociatedReadings.put(smartMeterId, new ArrayList<>());
        }
        meterAssociatedReadings.get(smartMeterId).addAll(electricityReadings);
    }
    
    public Map<String, List<ElectricityReading>> getReadings() {
    	System.out.println("meterAssociatedReadings = " + meterAssociatedReadings);
        return meterAssociatedReadings;
    }

	/*
	 * public Optional<List<ElectricityReading>> getReadingsOfLastOneWeek(String
	 * smartMeterId) { System.out.println("meterAssociatedReadings = " +
	 * meterAssociatedReadings);
	 * if(Objects.nonNull(meterAssociatedReadings.get(smartMeterId)) &&
	 * meterAssociatedReadings.get(smartMeterId).size() > 0 ) {
	 * 
	 * LocalDate.now().minusDays(7);
	 * //meterAssociatedReadings.get(smartMeterId).stream().filter(reading -> ); }
	 * 
	 * return Optional.ofNullable(meterAssociatedReadings.get(smartMeterId)); }
	 */
}
