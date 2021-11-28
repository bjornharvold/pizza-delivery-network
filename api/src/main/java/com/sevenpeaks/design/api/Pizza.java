package com.sevenpeaks.design.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.beans.ConstructorProperties;
import java.math.BigDecimal;

/**
 * Created on: 11/28/21.
 *
 * @author Bjorn Harvold
 * Responsibility:
 */
@Value
@Document
public class Pizza {
    @Schema(description = "Unique identifier", example = "pizza-1")
    @Id
    String id;

    @Schema(description = "Name of pizza", example = "Pizza Napoli")
    @NotBlank
    String name;

    @Schema(description = "Price of pizza", example = "12.50")
    @NotNull
    @Min(0)
    int price;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    @ConstructorProperties({
            "id",
            "name",
            "price"
    })
    public Pizza(
            @JsonProperty(value = "id", required = true) @NotBlank String id,
            @JsonProperty(value = "name", required = true) @NotBlank String name,
            @JsonProperty(value = "price", required = true) @NotNull @Min(0) int price
            ) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
