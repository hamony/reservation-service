package com.ubluetech.reservationservice.infrastructure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "kafka.topic")
public class KafkaTopicProperties {
    @NotNull @Size(max = 64)
    private String name;

    @Min(3) @NotNull
    private int partitions;

    @Min(1) @NotNull
    private int replicas;
}
