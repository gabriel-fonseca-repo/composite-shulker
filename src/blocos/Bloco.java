package blocos;

import gen.Item;

public class Bloco extends Item {

    private Integer dureza;

    public Integer getDureza() {
        return dureza;
    }

    public void setDureza(Integer dureza) {
        this.dureza = dureza;
    }

    @Override
    public String toString() {
        return super.getIdItem() + " - " + super.getNomeItem() + " - " + this.getDureza();
    }
}
