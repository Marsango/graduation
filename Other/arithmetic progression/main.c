#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
int * prog_arit(int n, int r){
    int *vetor2;
    vetor2 =(int *)(calloc(n, sizeof(int)));
    vetor2[1] = r;
    for (int i = 2; i < n; i++)
        vetor2[i] = vetor2[i-1] + r;
    return vetor2;
}

int main() {
    int n, r;
    int *vetor, *vetor2;
    scanf("%d %d", &n, &r);
    vetor =(int *)(calloc(n, sizeof(int)));
    vetor[0] = 0;
    if (n == 1 && n == 0)
        printf("%d", vetor[n]);
    else
        vetor2 = prog_arit(n, r);
    for (int i = 0; i < n; i++)
        printf("%d ", vetor2[i]);

    return 0;
}
