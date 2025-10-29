package com.example.grafana_app.service;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
//todo:: remove this class
public class DummyMetricsService {

    private final MeterRegistry meterRegistry;
    private final Random random = new Random();
    private static final Logger log = LoggerFactory.getLogger(DummyMetricsService.class);
    private final Map<String, Double> temperatureMap = new ConcurrentHashMap<>();
    private final Map<String, Double> humidityMap = new ConcurrentHashMap<>();
    private int id =1;
//    private final Map<String, Double> pressureMap = new ConcurrentHashMap<>();
//    private final Map<String, Double> gasIndexMap = new ConcurrentHashMap<>();

    public DummyMetricsService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;

        registerGauge("env_temperature", temperatureMap, id);
        registerGauge("env_humidity", humidityMap,id);
        id++;
//        registerGauge("dummy_pressure", pressureMap);
//        registerGauge("dummy_gas_index", gasIndexMap);
    }

    private void registerGauge(String name, Map<String, Double> map, Integer id) {
        Gauge.builder(name, map, m -> m.getOrDefault("xiot1", 0.0))
                .description("Simulated " + name + " metric")
                .tag("xiotId", id.toString())
                .tags("color", "red")
                .register(meterRegistry);
    }

    // Runs every 5 seconds
    @Scheduled(fixedRate = 5000)
    public void generateDummyMetrics() {
        double temp = 20 + random.nextDouble() * 10;     // 20°C – 30°C
        double humidity = 40 + random.nextDouble() * 20; // 40% – 60%
        double pressure = 900 + random.nextDouble() * 50; // 900–950 hPa
        double gas = 200 + random.nextDouble() * 50;     // Gas index

        temperatureMap.put("xiot1", temp);
        humidityMap.put("xiot1", humidity);
//        pressureMap.put("xiot1", pressure);
//        gasIndexMap.put("xiot1", gas);

        log.info("Dummy metrics updated → temp: {}, humidity: {}, for dummy xiot which its id is: {}",
                temp, humidity, id);
    }
}

