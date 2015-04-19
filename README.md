[![Build Status](https://travis-ci.org/Givonaldo/CompactadorDeArquivos.svg)](https://travis-ci.org/Givonaldo/CompactadorDeArquivos)

### CompactadorDeArquivos

#### Códificação de Huffman
===========
Compactador de Arquivos TXT, que utilizar a codificação de huffman para realização da compreção e 
exibe dados sobre o arquivo em forma de gráfico de Pizza. David Huffman propôs em 1952 um método 
estatístico que permite atribuir uma palavra de código binário aos diferentes símbolos a comprimir 
(pixéis ou caracteres por exemplo). O comprimento de cada palavra de código não é idêntico para todos 
os símbolos: os símbolos mais frequentes (que aparecem geralmente) são codificados com pequenas 
palavras de código, enquanto os símbolos mais raros recebem códigos binários mais longos. Fala-se 
de codificação de comprimento variável (em inglês VLC, para variable length code ) prefixada para 
designar este tipo de codificação porque nenhum código é o prefixo de outro. Assim, a sequência 
final de palavras codificadas com comprimentos variáveis será em média mais pequena do que com uma 
codificação de dimensão constante. O codificador de Huffman cria uma árvore ordenada a partir dos 
símbolos e a sua frequência de aparecimento. Os ramos são construídos recursivamente partindo dos 
símbolos menos frequentes. A construção da árvore faz-se ordenando inicialmente os símbolos por 
frequência de aparecimento. Sucessivamente, os dois símbolos de mais fraca frequência de aparecimento 
são retirados da lista e unidos a um nó cujo peso vale a soma das frequências dos dois símbolos. O 
símbolo de mais fraco peso é afectado ao ramo 1, o outro ao ramo 0 e assim sucessivamente, considerando 
cada nó formado como um novo símbolo, até obter um só nó parente, chamado raiz. O código de cada símbolo 
corresponde na sequência dos códigos ao longo do caminho que vai deste carácter à raiz. Assim, quanto 
mais o símbolo é “profundo” na árvore, mais a palavra de código será longa. 

![Alt Text](http://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Huffman_tree_2.svg/2000px-Huffman_tree_2.svg.png)


