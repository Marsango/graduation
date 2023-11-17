#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

typedef struct{
    int *v; // Array (vetor) de tamanho n
    int n; // tamanho do v
    int q; // quantidade de elementos preenchidos no vetor
}Vetor;

Vetor * iniciar(int n){
    Vetor *vetor = (Vetor*) malloc(sizeof(Vetor));
    vetor->v = (int*) (malloc(n * sizeof(int)));
    vetor->n = n;
    for(int i = 0; i < vetor->n; i++)
        scanf("%d", &vetor->v[i]);
    return vetor;
}
Vetor * concatenar(Vetor *v1, Vetor *v2){
    Vetor *vetor = (Vetor*) malloc(sizeof(Vetor));
    vetor->v = (int*) (malloc((v1->n + v2->n) * sizeof(int)));
    vetor->n = v1->n +v2->n;
    for(int i = 0; i < v1->n; i++)
        vetor->v[i] = v1->v[i];
    for(int i = v1->n; i < (v1->n+v2->n); i++)
        vetor->v[i] = v2->v[i - v1->n];
    return vetor;
}

Vetor * soma(Vetor *v1, Vetor *v2){
    Vetor *vetor = (Vetor*) malloc(sizeof(Vetor));
    if (v1->n >= v2->n){
        vetor->v = (int*) (malloc((v1->n) * sizeof(int)));
        vetor->n = v1->n;
        for(int i = 0; i < v1->n; i++)
            vetor->v[i] = v1->v[i] + v2->v[i];
    }
    else if (v2->n > v1->n){
        vetor->v = (int*) (malloc((v2->n) * sizeof(int)));
        vetor->n = v2->n;
        for(int i = 0; i < v2->n; i++)
            vetor->v[i] = v1->v[i] + v2->v[i];
    }
    return vetor;
}


int main() {
    Vetor *vetor, *vetor2, *concatena, *somar;
    int n1, n2;
    scanf("%d", &n1);
    vetor = iniciar(n1);

    scanf("%d", &n2);
    vetor2 = iniciar(n2);

    concatena = concatenar(vetor, vetor2);
    somar = soma(vetor, vetor2);



    for (int i = 0; i < concatena->n; i++){
        printf("%d ", concatena->v[i]);
        if (i == concatena->n -1)
            printf("\n");
    }
    for (int i = 0; i < somar->n; i++)
        printf("%d ", somar->v[i]);

    return 0;
}
