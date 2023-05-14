[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-f4981d0f882b2a3f0472912d15f9806d57e124e0fc890972558857b51b24a6f9.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=10524088)
# Manipulação de grafos
Projeto realizado sob orientação do professor João Caram para a disciplina de Laboratório de Programação Modular. O objetivo desse projeto é desenvolver uma aplicação modularizada em Java a partir da qual é possível realizar operações sobre grafos, como adição e remoção de arestas, além de executar buscas em profundidade e amplitude, considerando as particularidades de um grafo quanto à sua ponderação, direcionamento ou completude. 

## Correção e comentários

### Nota: 12,5

Grafo de teste 
![Grafo de teste](docs/grafoTeste.png)

---

- Adiciona aresta circular no não direcionado, causando erro no grau (1 a mais).
- Adiciona ida e volta no direcionado, causando possibilidade de caminhar onde não existe e erro no grau (1 a mais).
- No carregamento, adiciona aresta no vértice duplicado que é negado no grafo: o vértice do grafo fica sem aresta.
- Tamanho do grafo é vértices + arestas (retorna só arestas)
- Subgrafo "ao contrário": no lugar de criar os que existem, tenta retirar os que não existem. Porém, a comparação pára no último do subgrafo. (ex: se o último do subgrafo é 6 e o último do grafo é 10, deixa os vértices de 7 a 10)
- Salvar produziu arquivo com linha "4 4 264 5 265 4 265 5 26", que depois não é lido.
- BFS não encontra aresta direta 3-7 no grafo de teste acima
- DFS não retorna grafo com vértice 0 e retorna vértice 1 sem vizinhos no grafo de teste acima.
- "removeAresta" do Grafo dá um find em vértice que não existe e, assim, exceção para tentar remover aresta que não existe.
- App não apresenta menu: como a primeira operação(remover) dá erro, não consigo executar o resto.
---

- Aderência às classes do diagrama: 2/2 pontos
- Requisitos de grafos corretamente implementados: 5,5/12 pontos
  - Carregar/salvar		1/2 pontos
  - Grafo completo e subgrafo 1,5/3 pontos
  - Grafo ponderado/não ponderado 2/2 pontos
  - Busca em largura e profundidade 1/4 pontos
  - App para uso 0/1 ponto
- Documentação de código: 4/4 pontos
  
- Testes (quantidade e qualidade): 1/2 pontos
  - não incluem bfs e dfs; 
  - deixaram passar toros os erros acima.

## Alunos integrantes da equipe

* André Rodrigues de Freitas Faria
* Carlos Emanuel Silva e Melo Oliveira
* Gustavo Andrade Alves
* Letícia Teixeira Lott Carvalho
* Yan Rodrigues Nalon

## Professor responsável

* João Caram Santos de Oliveira

