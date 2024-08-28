## Caixeiro Viajante

O problema do caixeiro viajante (TSP - Travelling Salesman Problem) é um desafio clássico em teoria dos grafos e otimização. Suponha que um caixeiro viajante precise visitar `n` cidades diferentes, iniciando e encerrando sua viagem na primeira cidade. O objetivo é encontrar a rota que minimiza a distância total percorrida, considerando que o caixeiro pode ir diretamente de qualquer cidade a qualquer outra.

### Exemplo com 4 Cidades

Para ilustrar, considere o caso em que temos quatro cidades: A, B, C e D. O caixeiro deve considerar todas as possíveis rotas que passam por todas as cidades e retornam ao ponto de partida. 

Se o caixeiro iniciar sua viagem em A, ele pode percorrer as cidades na seguinte ordem:

1. **ABCDA**: A → B → C → D → A
2. **ABDCA**: A → B → D → C → A
3. **ACBDA**: A → C → B → D → A
4. **ACDBA**: A → C → D → B → A
5. **ADBCA**: A → D → B → C → A
6. **ADCBA**: A → D → C → B → A

Essas são todas as rotas possíveis que o caixeiro viajante deve considerar. O objetivo é calcular a rota com o menor custo total de viagem.
