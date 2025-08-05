package aaa;

import java.util.Comparator;
import java.util.HashMap;

public class Factory {

    public static Codificador criaCod(int nivelSeg){
        if(nivelSeg < 0){
            throw new IllegalArgumentException("Nivel nao pode ser negativo");
        }

        HashMap<Integer, Codificador> codificadores = new HashMap<>();
        codificadores.put(1, new CodificadorSimples());
        codificadores.put(5, new Codificador2000());
        codificadores.put(10, new CodSla());
        int highestSec = codificadores.keySet().parallelStream().max(Integer::compareTo).get();

        if(nivelSeg > highestSec){
            throw new IllegalArgumentException("Nivel nao pode ser comprido pelos codificadores atuais");
        }

        for(int i=nivelSeg;i<=highestSec;i++){
            if(codificadores.get(i)!=null){
                return codificadores.get(i);
            }
        }

        return null;

        /* else if (nivelSeg <= 1){
            return new CodificadorSimples();
        }
        else if(nivelSeg <= 5){
            return new Codificador2000();
        }
        else{
            return new CodSla();
        } */


    }
}