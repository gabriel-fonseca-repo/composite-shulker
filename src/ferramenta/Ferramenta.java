package ferramenta;

import gen.Item;

public class Ferramenta extends Item {

    private Integer durabilidade;

    public Integer getDurabilidade() {
        return durabilidade;
    }

    public void setDurabilidade(Integer durabilidade) {
        this.durabilidade = durabilidade;
    }

    @Override
    public String toString() {
        return super.getIdItem() + " - " + super.getNomeItem() + " - " + this.getDurabilidade() ;
    }
}
