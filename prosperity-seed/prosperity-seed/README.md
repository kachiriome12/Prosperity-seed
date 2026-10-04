# Prosperity Ore Seeds (Forge 1.20.1)

Addon do Mystical Agriculture. Adiciona a **Prosperity Ore Seeds**, uma semente que
planta numa fazenda do Mystical Agriculture e dropa **Prosperity Ore** na colheita.

Receita da semente (mesa de trabalho):

    P P P
    P S P      P = Prosperity Shard
    P P P      S = Inferium Seeds

Requer: Forge 47.1.0+, Mystical Agriculture 7.0.x e Cucumber.

## Gerar o .jar pelo GitHub

1. Suba esta pasta para um repositório no GitHub.
2. Aba **Actions** > workflow **Build mod jar** (roda sozinho a cada push).
3. Abra a execução e baixe o artifact **ProsperitySeed-jar**.

Para gerar localmente: `./gradlew build` (Java 17). O .jar sai em `build/libs`.
