# Iterator


Implementações do padrão de projeto Iterator na linguagem Java. Este conteúdo é complementar à apresentação sobre Iterator da disciplina Arquitetura de Software lecionada pelo professor Ricardo Terra, UFLA. 

<h2> AbstractList </h2>

Abaixo o diagrama de classes relacionado a uma implementação do padrão de projeto Iterator na API Java.
![alt tag](https://github.com/CarlosPereira27/Iterator/blob/master/diagramaDeClasses/IteratorJava.png)
Testes de unidade para este iterator podem ser encontrados [aqui] (https://github.com/CarlosPereira27/Iterator/blob/master/src/org/iterator/javateste).

<h2> Coleção </h2>

Abaixo o diagrama de classes relacionado à uma implementação do padrão de projeto Iterator envolvendo uma coleção. Onde a coleção possui um vetor interno para armazenar os objetos. Dois tipos de Iterator são implementados um que percorre o vetor do elemento localizado no índice 0 até o elemento do último índice e outro que percorre o vetor do elemento localizado no último índice até o elemento do índice 0. </h5>
![alt tag](https://github.com/CarlosPereira27/Iterator/blob/master/diagramaDeClasses/IteratorColecao.png)
A implementação e os testes de unidade deste diagrama podem ser encontrados [aqui] (https://github.com/CarlosPereira27/Iterator/blob/master/src/org/iterator/colecao).

<h2> Árvore Binária </h2>

Abaixo o diagrama de classes relacionado a uma implementação do padrão de projeto Iterator envolvendo uma árvore binária. Foram implementados 3 iterators para a árvore binária, um que percorre a árvore em ordem simétrica (em-ordem, padrão), outro em pré-ordem, e outro em pós-ordem.

1. Pré-ordem:
	- visita a raiz
	- percorrer a sua subárvore à esquerda
	- percorrer a sua subárvore à direita
2. Ordem simétrica:
	- percorrer a sua subárvore à esquerda
	- visita a raiz
	- percorrer a sua subárvore à direita
3. Pós-ordem:
	- percorrer a sua subárvore à esquerda 
	- percorrer a sua subárvore à direita
	- visita a raiz

![alt tag](https://github.com/CarlosPereira27/Iterator/blob/master/diagramaDeClasses/IteratorArvore.png)

A implementação e os testes de unidade deste diagrama podem ser encontrados [aqui] (https://github.com/CarlosPereira27/Iterator/blob/master/src/org/iterator/arvore).

<h2> Arquivo </h2>

Abaixo o diagrama de classes relacionado a uma implementação do padrão de projeto Iterator envolvendo um arquivo. Este iterator é implementado para ir retornando linha por linha do arquivo.

![alt tag](https://github.com/CarlosPereira27/Iterator/blob/master/diagramaDeClasses/IteratorArquivo.png)

A implementação e os testes de unidade deste diagrama podem ser encontrados [aqui] (https://github.com/CarlosPereira27/Iterator/blob/master/src/org/iterator/arquivo).
