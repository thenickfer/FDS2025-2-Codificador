package aaa;


import java.time.LocalDate;

public class CodSla implements Codificador{
    
    private final int[] arr = new int[256];

    public CodSla (){
        for (int i = 0; i <256; i++) {
           arr[i] = 255-i;
        }
    }

    public String getNome(){
        return "Codificador Sla";
    }

    // Retorna a data de imlementação do codificador (pode ser usado como versao)
    public LocalDate getDataCriacao(){
        return LocalDate.of(2025, 8, 04);
    }

    // Retorna o nivel de segurança do codificador (1 = muito baixo, 100 = muito alto)
    public int getNivelSeguranca(){
        return 10;
    }

    // Recebe um string e retorna o correspondente codificado
    public String codifica(String str){
        int turns = str.length();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append((char)arr[(c-1)]);
        }
        return sb.toString();
    }

    // Recebe um string codificado e retorna o correspondente decodificado
    public String decodifica(String str){
        int turns = str.length();
        StringBuilder sb = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]==(c-1)){
                    sb.append((char)i);
                }
            }
            
        }
        return sb.toString();
    }

}