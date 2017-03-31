package com.bloodnet.bloodnetapi.com.converter;

import java.sql.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.joda.time.LocalDate;

@Converter(autoApply = true)
public class LocalDatePersistenceConverter implements
    AttributeConverter<LocalDate, java.sql.Date > {
    @Override
    public Date convertToDatabaseColumn(LocalDate entityValue) {
        return Date.valueOf(entityValue.toString("yyyy-MM-dd"));
    }

    @Override
    public LocalDate convertToEntityAttribute(Date databaseValue) {
        return new LocalDate(databaseValue.toString());
    }




}