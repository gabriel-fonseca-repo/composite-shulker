package armadura;

import ferramenta.Ferramenta;

public class Armadura extends Ferramenta {

    private Integer defesa;

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    @Override
    public String toString() {
        return super.getIdItem() + " - " + super.getNomeItem() + " - " + super.getDurabilidade() + " - " + this.getDefesa();
    }
}
