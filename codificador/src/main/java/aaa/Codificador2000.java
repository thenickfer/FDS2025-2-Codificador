package aaa;

import java.time.LocalDate;

public class Codificador2000 implements Codificador{
    public String getNome(){
        return "Codificador2000";
    }

    public LocalDate getDataCriacao(){
        return LocalDate.of(2025,8,04);
    }

    public int getNivelSeguranca(){
        return 5;
    }

    public String codifica(String str){
        StringBuilder encoded = new StringBuilder();
        for (char c : str.toCharArray()){
            if(c==' '){
                encoded.append("/");
                continue;
            }
            String letter = String.format ("%02x", (int)c);
            encoded.append(letter);
            encoded.append(";");
        }
        return encoded.toString();
    }

    public String decodifica(String str){
        StringBuilder encoded = new StringBuilder();
        StringBuilder letter = new StringBuilder();

        for (char c : str.toCharArray()){
            if(c=='/'){
                encoded.append(" ");
                continue;
            }
            if (c==';'){
                int id = Integer.parseInt(letter.toString(),16);
                encoded.append((char)id);
                letter.delete(0,(letter.length()-1));
                letter.append("00");
                continue;
            }
            letter.append(c);
        }
        return encoded.toString();
    }
}