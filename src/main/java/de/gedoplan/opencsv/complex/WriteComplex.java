/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.gedoplan.opencsv.complex;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dominik Mathmann
 */
public class WriteComplex {

    public static void main(String[] args) throws UnsupportedEncodingException, IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {       
        Material mat01 = new Material();
        mat01.setDescription("Material 01");
        mat01.setId(1L);
        mat01.setPrices(new ArrayList<>());

        mat01.getPrices().add(new Price(LocalDate.now(), LocalDate.now(), new BigDecimal(155.60)));
        mat01.getPrices().add(new Price(LocalDate.now(), LocalDate.now(), new BigDecimal(10.50)));

        Material mat02 = new Material();
        mat02.setDescription("Material 021");
        mat02.setId(55L);
        mat02.setPrices(new ArrayList<>());

        mat02.getPrices().add(new Price(LocalDate.now(), LocalDate.now(), new BigDecimal(500.60)));
        mat02.getPrices().add(new Price(LocalDate.now(), LocalDate.now(), new BigDecimal(102.50)));

        List<Material> materials = new ArrayList<>();
        materials.add(mat01);
        materials.add(mat02);

        Writer writer = new FileWriter("out.csv");
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).withSeparator(';').build();
        beanToCsv.write(materials);
        writer.close();

        // and read again
        Reader reader = new FileReader("out.csv");
        List<Material> beans = new CsvToBeanBuilder<Material>(reader)
                .withSeparator(';').withType(Material.class).build().parse();

        beans.forEach(System.out::println);
    }
}
