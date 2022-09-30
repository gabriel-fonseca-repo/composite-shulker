package inventario;

import gen.Item;

import java.util.ArrayList;

public interface Inventario {

    ArrayList<Item> getItensGuardados();

    void setItensGuardados(ArrayList<Item> itensGuardados);

    Integer getEspacoRestante();

    void setEspacoRestante(Integer espacoRestante);

    void printAllItens(String caractereAcumulado, String caractere);

}
