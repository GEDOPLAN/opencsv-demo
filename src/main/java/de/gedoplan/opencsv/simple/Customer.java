package de.gedoplan.opencsv.simple;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Dominik Mathmann
 */
@Getter
@Setter
@ToString
public class Customer {

    @CsvBindByName(column = "customerid")
    private Long customerid;

    @CsvBindByName(column = "firstname")
    private String firstname;

    @CsvBindByName(column = "lastname")
    private String lastname;

    @CsvBindByName(column = "registerdate")
    @CsvDate("dd.MM.yyyy")
    private Date registerdate;

    @CsvBindByName(column = "discount")
    private Double discount;

}
