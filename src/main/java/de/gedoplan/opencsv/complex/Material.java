package de.gedoplan.opencsv.complex;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Dominik Mathmann
 */
@Getter
@Setter
public class Material {

    @CsvBindByPosition(position = 0)
    private Long id;

    @CsvBindByPosition(position = 1)
    private String description;

    @CsvBindAndSplitByPosition(position = 2, elementType = Price.class, splitOn = "\\|", converter = PriceConverter.class)
    private List<Price> prices;

    @CsvBindByPosition(position = 3)
    private Double averagePrice;

    public Double getAveragePrice() {
        return prices.stream().map(Price::getPrice)
                .mapToDouble(BigDecimal::doubleValue)
                .average()
                .orElse(0.);
    }
}
