package de.gedoplan.opencsv.complex;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Dominik Mathmann
 */
@Getter
@Setter
@AllArgsConstructor
public class Price {

    private LocalDate validFrom;

    private LocalDate validTo;

    private BigDecimal price;
}
