package br.com.sassotabacco.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conversor {
	
	public Date ConvercaoStringData(String data) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dataFormatada = null;
        try {
            dataFormatada = df.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Conversor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataFormatada;
    }
	
	public Date SomarDiasData(Date data, int dias) {
        Calendar c = new GregorianCalendar();
        c.setTime(data);
        if (dias != 0) {
            c.add(Calendar.DAY_OF_MONTH, dias);
        }
        return (c.getTime());
    }
	
	public String ConvercaoData(Date data) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = df.format(data);
        return dataFormatada;
    }
	
	public String ConvercaoDataPadrao(Date data) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = df.format(data);
        return dataFormatada;
    }
	
	public int getRestoMes(int mes) {
		if ((mes==1) || (mes==3) || (mes==5) || (mes==7) || (mes==8) || (mes==10) || (mes==12)) {
			return 31;
		} else if ((mes==4) || (mes==6) || (mes==9) || (mes==11)) {
			return 30;
		} else return 28;
	}

}
