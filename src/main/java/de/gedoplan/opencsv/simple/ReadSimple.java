/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.gedoplan.opencsv.simple;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 *
 * @author Dominik Mathmann
 */
public class ReadSimple {
    
    public static void main(String[] args) throws UnsupportedEncodingException {
        
        List<Customer> beans = new CsvToBeanBuilder<Customer>(new InputStreamReader(ReadSimple.class.getClassLoader().getResourceAsStream("demo01.csv"), "UTF-8"))
                .withSeparator(';').withType(Customer.class).build().parse();
        
        beans.forEach(System.out::println);
    }
}
