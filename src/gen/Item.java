package gen;

import java.awt.image.BufferedImage;

public class Item {

    private Long idItem;

    private String nomeItem;

    private BufferedImage sprite;

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    @Override
    public String toString() {
        return getIdItem() + " - " + getNomeItem();
    }

}
