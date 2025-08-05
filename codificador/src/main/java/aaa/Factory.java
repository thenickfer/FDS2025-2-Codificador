package aaa;

public class Factory {

    public static Codificador criaCod(int nivelSeg){
        if(nivelSeg < 0){
            throw new IllegalArgumentException("Nivel nao pode ser negativo");
        }
        else if (nivelSeg <= 1){
            return new CodificadorSimples();
        }
        else if(nivelSeg <= 5){
            return new Codificador2000();
        }
        else{
            return new CodSla();
        }
    }
}