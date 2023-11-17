#include <stdio.h>
#include <stdlib.h>
int soma_nat(int n){
    if (n == 0)
        return n;
    else{
        int soma;
        soma += n % 10;
        n /= 10;
        return(soma + soma_nat(n));
    }
    }
int main()
{
    int n, res;
    scanf("%d", &n);
    res = soma_nat(n);
    printf("%d", res);
    return 0;
}
