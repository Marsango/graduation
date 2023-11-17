#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <limits.h>
#define TAM_MAX 100

typedef struct fila{
    int item[TAM_MAX];
    int ini;
    int fim;
    int tam;
}Fila;

Fila* criar_fila(){
    Fila *f = (Fila*) malloc(sizeof(Fila));

    f->ini = -1;
    f->fim = -1;
    f->tam = 0;

    return f;
}

int fila_cheia(Fila *f){

    if (f == NULL)
        return -1;
    else if (f->tam < TAM_MAX)
        return 0;
    else
        return 1;
}


int fila_vazia(Fila *f){
    if (f == NULL)
        return -1;
    else if (f->tam > 0)
        return 0;
    else
        return 1;
}


int enfileirar(Fila *f, int chave){

    if (f == NULL)
        f = criar_fila();

    if (!fila_cheia(f)){

        if (f->ini < 0)
            f->ini = f->fim = 0;


        if (f->fim < TAM_MAX - 1)
            f->fim++;
        else
            f->fim = 0;


        f->item[f->fim] = chave;


        f->tam++;

        return 1;
    }

    return 0;
}

int desenfileirar(Fila *f){
    int item = INT_MIN;


    if (!fila_vazia(f)){
        item = f->item[f->ini];
        f->tam--;


    if (f->tam == 0){
            f->ini = -1;
            f->fim = -1;
        }else if (f->ini < TAM_MAX - 1)
            f->ini++;
        else
            f->ini = 0;
    }

    return item;
}


void imprimir_fila(Fila *f){

    Fila aux = *f;
    int item;

    while (!fila_vazia(&aux)){
        item = desenfileirar(&aux);

        printf("%d ", item);
    }

    printf("\n");
}

// liberar fila
void liberar_fila(Fila *f){
    if (f != NULL)
        free(f);
}

void divisao(Fila *f1, Fila *f2, Fila *f3){
    if (f1 != NULL){
        while(!fila_vazia(f1)){
            enfileirar(f2, f1->item[f1->ini]);
            desenfileirar(f1);
            if(!fila_vazia(f1)){
            enfileirar(f3, f1->item[f1->ini]);
            desenfileirar(f1);
            }
        }
    }

}
int main() {
    Fila *f1, *f2, *f3;
    int item = 0;
    f1 = criar_fila();
    f2 = criar_fila();
    f3 = criar_fila();
    scanf("%d", &item);
    while(item != -1){
        enfileirar(f1, item);
        scanf("%d", &item);
    }
    divisao(f1, f2, f3);
    imprimir_fila(f2);
    imprimir_fila(f3);
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    return 0;
}
