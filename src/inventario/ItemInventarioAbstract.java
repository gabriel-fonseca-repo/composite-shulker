package inventario;

import gen.Item;

import java.util.ArrayList;

public abstract class ItemInventarioAbstract extends Item implements Inventario {

    public static final Integer TOTAL_ESPACOS = 30;

    private ArrayList<Item> itensGuardados;

    private Integer espacoRestante;

    @Override
    public ArrayList<Item> getItensGuardados() {
        return itensGuardados;
    }

    @Override
    public void setItensGuardados(ArrayList<Item> itensGuardados) {
        this.itensGuardados = itensGuardados;
    }

    @Override
    public Integer getEspacoRestante() {
        return espacoRestante;
    }

    @Override
    public void setEspacoRestante(Integer espacoRestante) {
        this.espacoRestante = espacoRestante;
    }

    @Override
    public void printAllItens(String caractereAcumulado, String caractere) {
        caractereAcumulado += caractere;
        for (Item item : itensGuardados) {
            System.out.println(caractereAcumulado + " " + item.toString());
            if (item instanceof ItemInventarioAbstract) {
                ((ItemInventarioAbstract) item).printAllItens(caractereAcumulado, caractere);
            }
        }
    }

}
