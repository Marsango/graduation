#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
typedef struct Cell Cell;
typedef struct PilhaE PilhaE;

struct Cell{
    int item;
    Cell *next;
};

struct PilhaE{
    Cell *topo;
};


Cell* criar_celula(int key){
    Cell *c = (Cell*) malloc(sizeof(Cell));
    c->item = key;

    c->next = NULL;

    return c;
}


PilhaE* criar_pilhaE(){
    PilhaE* p = (PilhaE*) malloc(sizeof(PilhaE));

    p->topo = NULL;

    return p;
}

int pilhaE_vazia(PilhaE *p){
    return (p == NULL) || (p->topo == NULL);
}

void empilhar(int key, PilhaE *p){
    Cell *aux;
    if (p == NULL)
        p = criar_pilhaE();


    aux = criar_celula(key);

    aux->next = p->topo;

    p->topo = aux;
}


int desempilhar(PilhaE *p){
    Cell *aux;
    int item = INT_MIN;

    if (!pilhaE_vazia(p)){

        aux = p->topo;


        item = aux->item;

        p->topo = aux->next;


        free(aux);
    }

    return item;
}


void imprimir_pilha(PilhaE *p){
    Cell *aux;

    if (!pilhaE_vazia(p)){
        aux = p->topo;

        while (aux != NULL){
            printf("%d", aux->item);

            aux = aux->next;
        }
    }
}


int liberar_pilha(PilhaE *p){
    if (p != NULL){
        while (!pilhaE_vazia(p))
            desempilhar(p);

        free(p);

        return 1;
    }

    return 0;
}
void binario(int n, PilhaE *p){
    if (n == 0){
        empilhar(0, p);
        return;
    }
    else{
    while(n != 1){
        empilhar(n % 2, p);
        if( n == 2 || n == 3)
            empilhar(1, p);
        n = n/2;
    }
    }
}
int main() {
    int n;
    PilhaE *p = criar_pilhaE();
    scanf("%d", &n);
    binario(n, p);
    imprimir_pilha(p);
    return 0;
}
