package br.uefs.ecomp.sacMariana.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PegaData {


 public static Date pegaData( ){
        // TODO code application logic here

        //  im pressao do formato da data a ser inserida
       System.out.println("Entre data e hora no formato");
       System.out.println("dd/mm/aaaa hh");

       //  Abre o input
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       String leitura = null;

       try {
          leitura = br.readLine();
       } catch (IOException ioe) {
          System.exit(1);
       }

       Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh");
            date = (java.util.Date)formatter.parse(leitura);

            // Caso a data esteja no formato errado, irá informar o erro do
            // formato e pedirá uma nova data
        } catch (ParseException e) {
            System.out.println("Data com o formato incorreto!");
            pegaData();
        }
     return date;
    }

}
