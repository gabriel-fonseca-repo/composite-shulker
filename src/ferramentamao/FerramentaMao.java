package ferramentamao;

import blocos.Bloco;
import ferramenta.Ferramenta;

import java.util.List;

public class FerramentaMao extends Ferramenta {

    private Integer velocidadeQuebrarBloco;

    private List<Bloco> blocosQueQuebramFacil;

    public Integer getVelocidadeQuebrarBloco() {
        return velocidadeQuebrarBloco;
    }

    public void setVelocidadeQuebrarBloco(Integer velocidadeQuebrarBloco) {
        this.velocidadeQuebrarBloco = velocidadeQuebrarBloco;
    }

    public List<Bloco> getBlocosQueQuebramFacil() {
        return blocosQueQuebramFacil;
    }

    public void setBlocosQueQuebramFacil(List<Bloco> blocosQueQuebramFacil) {
        this.blocosQueQuebramFacil = blocosQueQuebramFacil;
    }

    @Override
    public String toString() {
        return super.getIdItem() + " - " + super.getNomeItem() + " - " + super.getDurabilidade() + " - " + this.getVelocidadeQuebrarBloco();
    }
}
