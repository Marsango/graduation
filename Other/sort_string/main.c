#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
void troca(char **vstr, int p1, int p2){
    char *str;

    str = vstr[p1];
    vstr[p1] = vstr[p2];
    vstr[p2] = str;
}
int comparar_char(char c1, char c2){
    if (c1 == c2) return 0;
    else if (c1 < c2) return -1;
    else return 1;
}

int comparar(char s1[], char s2[]){
    int i;

    for (i = 0; (s1[i] == s2[i]) && (s1[i] != '\0') && (s2[i] != '\0'); i++);

    return comparar_char(s1[i], s2[i]);
}

void ordenar(char **v, int n, int m){
    int part = n;
    int n_cima = n - 1, n_baixo = 0;
    int i = n_cima, j = n_baixo;

    while(part > m){
    char *pivo = v[(i + j) / 2];

    do{
        while ((comparar(v[i], pivo) < 0) && (i < j))
            i++;

        while ((comparar(v[j], pivo) > 0) && (j > i))
            j--;

        if (i <= j){
            troca(v, i, j);
            i++;
            j--;
        }
    }while (i <= j);

    if (j > n_cima)
        i = n_cima;
    if (i < n_baixo)
        j = n_baixo;
    part = j - i;
}
    int t = 1;
    i = 1;
    j = 1;

    for (i = 0; (i < n - 1) && t; i++){
        t = 0;

    for (j = 0; j < n - i - 1; j++)
        if (comparar(v[j], v[j + 1]) > 0){
            troca(v, j, j + 1);
            t = 1;
        }
    }


}
int main() {
    int n, m;
    scanf("%d", &n);
    scanf("%d", &m);
    char **v = (char **)(malloc(sizeof(char *) * n));
    for (int i = 0; i < n; i++)
        v[i] = (char *)(malloc(sizeof(char) * n));
    for (int i = 0; i < n; i++)
        scanf("%s", v[i]);
    ordenar(v, n, m);
    for (int i = 0; i < n; i++)
        printf("%s \n", v[i]);
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    return 0;
}
