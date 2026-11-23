# Narutoto HUD Numérica

Addon independente (ID `coracoesnumero`) para **Minecraft Java 1.20.1 + Forge 47.x**, pensado para o NarutoTo 0.4.1.

## O que altera
- Cancela a camada vanilla de corações e mostra a vida como `vida atual/vida máxima` (por exemplo, `20/20`).
- Cancela também a camada vanilla `ARMOR_LEVEL`, removendo os ícones de armadura da parte superior da HUD.
- Não altera a barra de chakra, inventário ou outros elementos do NarutoTo.

## Instalação
Este pacote é o **projeto-fonte**, não um `.jar` pronto. Para gerar o mod:
1. Instale Java 17 e Gradle.
2. Abra esta pasta em uma IDE compatível com Gradle ou execute `gradle build`.
3. O arquivo compilado ficará em `build/libs/`.
4. Coloque o `.jar` compilado na pasta `mods` junto do NarutoTo 0.4.1 e Forge 1.20.1.

## Observação
O addon não modifica nem substitui o arquivo original `narutoto-0_4_1-forge`. Teste em uma cópia do mundo primeiro. Remova versões antigas deste addon da pasta `mods` antes de instalar o JAR recompilado.
