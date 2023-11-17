#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#define TAM_MAX 100

typedef struct Pilha Pilha;

struct Pilha{
    int item[TAM_MAX];
    int topo;
};

Pilha* criar_pilha(){
    Pilha *p = (Pilha*) malloc(sizeof(Pilha));

    p->topo = -1;

    return p;
}


int pilha_cheia(Pilha *p){
    if (p == NULL)
        return -1;
    else if (p->topo == (TAM_MAX - 1))
        return 1;
    else
        return 0;
}

int pilha_vazia(Pilha *p){
    if (p == NULL)
        return -1;
    else if (p->topo == -1)
        return 1;
    else
        return 0;
}

int empilhar(Pilha *p, int item){
    if (p == NULL)
        p = criar_pilha();

    if (!pilha_cheia(p)){
        p->topo++;

        p->item[p->topo] = item;

        return 1;
    }

    return 0;
}


int desempilhar (Pilha *p){
    int item = INT_MIN;
    if (!pilha_vazia(p)){
        item = p->item[p->topo];

        p->topo--;
    }

    return item;
}


void imprimir_pilha(Pilha *p){

    Pilha aux = *p;
    int item;

    while (!pilha_vazia(&aux)){
        item = desempilhar(&aux);

        printf("%d ", item);
    }
}
void liberar_pilha(Pilha *p){
    if (p != NULL)
        free(p);
}

Pilha * concatenar(Pilha *p1, Pilha *p2){
    Pilha *l3 = criar_pilha();
    Pilha *impar = criar_pilha();
    Pilha *par = criar_pilha();
    if (pilha_vazia(p1)){
        while(p2->topo != -1){
            if(p2->item[p2->topo] % 2 == 0){
                empilhar(par, p2->item[p2->topo]);
                desempilhar(p2);
            }
            else{
                empilhar(impar, p2->item[p2->topo]);
                desempilhar(p2);
        }
    }
    }
    else if (pilha_vazia(p2)){
        while(p1->topo != -1){
            if(p1->item[p1->topo] % 2 == 0){
                empilhar(par, p1->item[p1->topo]);
                desempilhar(p1);
            }
            else{
                empilhar(impar, p1->item[p1->topo]);
                desempilhar(p1);
        }
    }
    }
    else
    {
        while(!pilha_vazia(p2)){
            if(p2->item[p2->topo] % 2 == 0){
                empilhar(par, p2->item[p2->topo]);
                desempilhar(p2);
            }
            else{
                empilhar(impar, p2->item[p2->topo]);
                desempilhar(p2);
            }
     }
        while(!pilha_vazia(p1)){
            if(p1->item[p1->topo] % 2 == 0){
                empilhar(par, p1->item[p1->topo]);
                desempilhar(p1);
            }
            else{
                empilhar(impar, p1->item[p1->topo]);
                desempilhar(p1);
            }
    }

    }
    for (int i = 0; i < impar->topo; i++){
            empilhar(l3, impar->item[impar->topo]);
            desempilhar(impar);
    }
    for (int i = 0; i < par->topo; i++){
            empilhar(l3, par->item[par->topo]);
            desempilhar(par);
    }

     return l3;
        }
Pilha * entrada (Pilha *p){
    int item = 0;
    while(item != -1){
        empilhar(p, item);
        if(item == -1)
            break;
        scanf("%d", &item);
            }
    return p;
}
int main(){
            Pilha *p1, *p2, *p3;
            p1 = criar_pilha();
            p2 = criar_pilha();
            p3 = criar_pilha();
            int item = 0;
            while(item != -1){
                scanf("%d", &item);
                if(item == -1)
                    break;
                empilhar(p1, item);
            }
            item = 0;
            while(item != -1){
                scanf("%d", &item);
                if(item == -1)
                    break;
                empilhar(p2, item);
            }
            p3 = concatenar(p1, p2);
            imprimir_pilha(p3);
            return 0;
}
