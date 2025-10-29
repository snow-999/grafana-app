package com.example.grafana_app.service;

import com.example.grafana_app.dto.UserDto;
import com.example.grafana_app.entity.UserEntity;
import com.example.grafana_app.mapper.UserMapper;
import com.example.grafana_app.reposetory.UserRepo;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRepo userRepo;
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    MeterRegistry meterRegistry;




    public void createUser(UserDto userDto) {
        UserEntity entity = userMapper.mapToEntity(userDto);
        log.info("this is my user dto {}", userDto );
        entity = userRepo.save(entity);
//        userDto = userMapper.mapToDto(entity);
    }

    public UserDto getUser(long id) {
        UserEntity userEntity = userRepo.findById(id).orElseThrow(()-> new RuntimeException("No User With This Id"));
        return userMapper.mapToDto(userEntity);
    }
    @Scheduled(fixedRate = 5000)
    public void sendLogs() {
        log.info("my number is " + 12);
        Counter.builder("xiot_temperature")
                .tag("sensor", "A")
                .register(meterRegistry)
                .increment();
        Counter.builder("xiot_humidity")
                .tag("sensor", "B")
                .register(meterRegistry);
    }
}