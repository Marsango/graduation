#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

typedef struct {
    char nome[255];
    int saquesTotal;
    int bloqueiosTotal;
    int ataquesTotal;
    int saquesSucesso;
    int bloqueiosSucesso;
    int ataquesSucesso;
}Jogador;
typedef struct {
    float pSaques;
    float pBloqueios;
    float pAtaque;
}Percent;
void calculoPorcentagem (Jogador otime, Percent *percent){
    percent->pSaques = ( (float) otime.saquesSucesso/otime.saquesTotal) * 100;
    percent->pBloqueios = ( (float) otime.bloqueiosSucesso/otime.bloqueiosTotal) * 100;
    percent->pAtaque = ( (float) otime.ataquesSucesso/otime.ataquesTotal) * 100;
}
int main() {
    Jogador jogador;
    Jogador time;
    time.saquesSucesso = 0, time.bloqueiosSucesso = 0, time.ataquesSucesso = 0, time.saquesTotal = 0, time.bloqueiosTotal = 0, time.ataquesTotal = 0;
    Percent percent;
    int cont;
    scanf("%d", &cont);

    for (int i = 0; cont > i; i++){
        scanf("%s", jogador.nome);
        scanf("%d %d %d", &jogador.saquesTotal, &jogador.bloqueiosTotal, &jogador.ataquesTotal);
        scanf("%d %d %d", &jogador.saquesSucesso, &jogador.bloqueiosSucesso, &jogador.ataquesSucesso);
        time.saquesSucesso += jogador.saquesSucesso;
        time.bloqueiosSucesso += jogador.bloqueiosSucesso;
        time.ataquesSucesso += jogador.ataquesSucesso;
        time.saquesTotal += jogador.saquesTotal;
        time.bloqueiosTotal += jogador.bloqueiosTotal;
        time.ataquesTotal += jogador.ataquesTotal;
    }
    calculoPorcentagem(time, &percent);
    printf("Pontos de saque: %.2f%%\n", percent.pSaques);
    printf("Pontos de Bloqueio: %.2f%%\n", percent.pBloqueios);
    printf("Pontos de Ataque: %.2f%%\n", percent.pAtaque);


    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    return 0;
}
