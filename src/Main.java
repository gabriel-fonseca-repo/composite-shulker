import armadura.Armadura;
import ferramenta.Ferramenta;
import ferramentamao.FerramentaMao;
import shulker.Shulker;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Shulker ferramentas = new Shulker();
        ferramentas.setIdItem(1L);
        ferramentas.setNomeItem("Shulker ferramentas");
        ferramentas.setItensGuardados(new ArrayList<>());

        FerramentaMao picareta = new FerramentaMao();
        picareta.setVelocidadeQuebrarBloco(25);
        picareta.setIdItem(1L);
        picareta.setDurabilidade(20);
        picareta.setNomeItem("Picareta de diamante");
        ferramentas.getItensGuardados().add(picareta);

        FerramentaMao pa = new FerramentaMao();
        pa.setVelocidadeQuebrarBloco(30);
        pa.setIdItem(2L);
        pa.setDurabilidade(25);
        pa.setNomeItem("Pá de diamante");
        ferramentas.getItensGuardados().add(pa);

        FerramentaMao machado = new FerramentaMao();
        machado.setVelocidadeQuebrarBloco(30);
        machado.setIdItem(3L);
        machado.setDurabilidade(25);
        machado.setNomeItem("Machado de diamante");
        ferramentas.getItensGuardados().add(machado);

        Shulker shulkers = new Shulker();
        shulkers.setIdItem(1L);
        shulkers.setNomeItem("Shulker de shulkers");
        shulkers.setItensGuardados(new ArrayList<>());
        shulkers.getItensGuardados().add(ferramentas);

        Shulker armaduras = new Shulker();
        armaduras.setIdItem(2L);
        armaduras.setNomeItem("Shulker de armaduras");
        armaduras.setItensGuardados(new ArrayList<>());

        Armadura torso = new Armadura();
        torso.setDefesa(24);
        torso.setIdItem(1L);
        torso.setDurabilidade(50);
        torso.setNomeItem("Torso diamante");
        armaduras.getItensGuardados().add(torso);

        Armadura perneiras = new Armadura();
        perneiras.setDefesa(24);
        perneiras.setIdItem(2L);
        perneiras.setDurabilidade(50);
        perneiras.setNomeItem("Perneiras diamante");
        armaduras.getItensGuardados().add(perneiras);

        Armadura capacete = new Armadura();
        capacete.setDefesa(26);
        capacete.setIdItem(3L);
        capacete.setDurabilidade(50);
        capacete.setNomeItem("Capacete diamante");
        armaduras.getItensGuardados().add(capacete);

        Armadura botas = new Armadura();
        botas.setDefesa(24);
        botas.setIdItem(4L);
        botas.setDurabilidade(50);
        botas.setNomeItem("Botas diamante");
        armaduras.getItensGuardados().add(botas);

        shulkers.getItensGuardados().add(armaduras);

        InventarioJogador inv = new InventarioJogador();
        inv.setItensGuardados(new ArrayList<>());
        inv.getItensGuardados().add(shulkers);
        inv.printAllItens("", "-");
    }

}