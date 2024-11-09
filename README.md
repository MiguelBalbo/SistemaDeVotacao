# SistemaDeVotacao
Sistema de votação feito em Java que tinha que seguir alguns requisitos:

Criar uma classe abstrata segundo:
.....................................................
.	              	Votação               	         	.
.....................................................
.    NumeroSeção        :      NumeroCandidato      . 
.....................................................
.         int	          :           int             .
.....................................................


Criar classe Votação2021, conforme:

1)	Cadastrar 200 registros com votos de eleitores a partir do método  
    NúmeroSeção       (0 a 10)     (1)
    NúmeroCandidato (0 a 300) (1)
  	(Nesse caso, foi utilizado um método de números aleatórios para gerar os 200 votos, mas é fácil de trocar a linha para colocar a input do usuário)
             

3)	Classificar os registros em memória por NumeroSeção e exibir mensagem “dados classificados”;

4)	Gravar dados da votação em arquivo Votação2021.txt e exibir mensagem “arquivo gerado”

5)	Chamada de Menu para mostrar Indicadores:

4.1) Quantidade de eleitores por Seção (procedimento);
4.2) Número da Seção com maior e menor números de eleitores (procedimento);
4.3) Quantidade de votos por candidato (procedimento);
4.4) Exibir os 10 candidatos mais votados e suas quantidades (procedimento);


----------------------------------------------------------------
|     	SISTEMA DE VOTAÇÃO		                               	|
|      1 – Carregar Seção/Número Eleitor 	                    |
|      2 – Classificar por Seção      		                    |
|      3 – Gravar Registros                                	  |
|      4 – Mostrar Indicadores                                |
|      9 – Finalizar                                          |
----------------------------------------------------------------

-----------------------------------------------------------
|	    Mostrar Indicadores			                            |
|        Estatísticas de Votação em 2021		              |
| 1 – Quantidade Eleitores por Seção	                    |
| 2 –Seção com Maior e Menor número de Eleitores          |
| 3 – Quantidade de votos por candidato                   |
| 4 – 10 primeiros colocadas (nro cand. e qtd votos)      |
| 9 – Finaliza consulta	                		              |
-----------------------------------------------------------



