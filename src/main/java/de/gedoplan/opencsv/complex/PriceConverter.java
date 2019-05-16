package de.gedoplan.opencsv.complex;

import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import static java.awt.SystemColor.text;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Dominik Mathmann
 */
public class PriceConverter extends AbstractCsvConverter {

    private final DecimalFormat decimalFormat = new DecimalFormat("#,##");

    @Override
    public String convertToWrite(Object value) throws CsvDataTypeMismatchException {
        final Price price = (Price) value;
        final String priceValue = decimalFormat.format((price).getPrice());
        final String until = price.getValidTo().format(DateTimeFormatter.ISO_DATE);
        final String from = price.getValidTo().format(DateTimeFormatter.ISO_DATE);
        return String.format("%s*%s*%s|", from, until, priceValue);
    }

    @Override
    public Object convertToRead(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        final String[] splits = value.trim().split("\\*");
        LocalDate from=LocalDate.parse(splits[0], DateTimeFormatter.ISO_DATE);
        LocalDate to=LocalDate.parse(splits[1], DateTimeFormatter.ISO_DATE);
        BigDecimal price = new BigDecimal(splits[2]);
        return new Price(from, to, price);
    }
}
