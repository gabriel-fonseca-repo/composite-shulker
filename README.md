# Padrão de projeto GOF - Composite.

A implementação do padrão composite foi feita através da abstração de um item presente no jogo Minecraft, que é
a [shulker box](https://minecraft.fandom.com/pt/wiki/Caixa_de_shulker), que se trata de um item, possível de ser
guardado no inventário tanto do jogador quanto em baús, que também se comporta como um baú, podendo ser guardada dentro
de si mesma, assim gerando uma capacidade teoricamente infinita de espaço para armazenamento de itens. Prossigamos para
a implementação.

![](https://media2.giphy.com/media/MY1KAimvtdYoWyzmGO/giphy.gif?cid=790b76113b9ed9b5fc622d87e2ae89943cab9336a005a36a&rid=giphy.gif&ct=g)

1. Começamos com a implementação de uma classe genérica para itens gerais que são guardados nos inventários.

```java
public class Item {

    private Long idItem;

    private String nomeItem;

    private BufferedImage sprite;

    /* getters e setters */

}
```

2. Logo então criamos uma classe para representar o inventário de forma genérica, que será utilizada nas implementações
   de objetos como baús, shulkers e o próprio inventário do jogador.

```java
public interface Inventario {

    ArrayList<Item> getItensGuardados();

    void setItensGuardados(ArrayList<Item> itensGuardados);

    Integer getEspacoRestante();

    void setEspacoRestante(Integer espacoRestante);

    void printAllItens(String caractereAcumulado, String caractere);

}
```

3. No próximo passo criamos uma classe abstrata que implementa alguns métodos da classe inventário que devem seguir um
   padrão.

```java
public abstract class InventarioAbstract implements Inventario {

    public static final Integer TOTAL_ESPACOS = 30;

    private ArrayList<Item> itensGuardados;

    private Integer espacoRestante;

    /* getters e setters */

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
```

4. Agora implementamos uma classe que cruza as características de um inventário com a de um item, em caminho para
   podermos criar itens híbridos tais como shulkers e baús.

```java
public abstract class ItemInventarioAbstract extends Item implements Inventario {

    public static final Integer TOTAL_ESPACOS = 30;

    private ArrayList<Item> itensGuardados;

    private Integer espacoRestante;

    /* getters e setters */

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
```

5. Criamos agora as classes finais de itens inventários e de inventários apenas.

```java
public class InventarioJogador extends InventarioAbstract { }

public class Shulker extends ItemInventarioAbstract { }
```

6. Output do código:

```java
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
```

```
- 1 - Shulker de shulkers
-- 1 - Shulker ferramentas
--- 1 - Picareta de diamante - 20 - 25
--- 2 - Pá de diamante - 25 - 30
--- 3 - Machado de diamante - 25 - 30
-- 2 - Shulker de armaduras
--- 1 - Torso diamante - 50 - 24
--- 2 - Perneiras diamante - 50 - 24
--- 3 - Capacete diamante - 50 - 26
--- 4 - Botas diamante - 50 - 24
```
