package br.com.monkeys_money.cross;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateConveter {

    public static Date convertToDateUtil(final LocalDateTime date){
        return Date.from(date.atZone(ZoneId.of("America/Sao_Paulo")).toInstant());
    }

    public static LocalDateTime convertToLocalDateTime(final Long time){
        Date date = new Date(time);
        return date.toInstant()
                .atZone(ZoneId.of("America/Sao_Paulo"))
                .toLocalDateTime();
    }
}
