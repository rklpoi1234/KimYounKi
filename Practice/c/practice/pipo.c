#include <stdio.h>
#include <stdlib.h>

int fibo(int n);

int main(void){
    int n;
    int i;

    printf("\n피보나치 수 입력 : \n");
    scanf("%d",&n);

    for (int i = 0; i < n; i++) {
        printf("%d", fibo(i) );
    }
    printf("\n\n");
    system("pause");
    return 0;
}

int fibo(int n){
    if(n==0) return 0;
    else
        if(n==1) return 1;
        else
            return fibo(n-1) + fibo(n-2);

}

----------------------------for 문 이용---------------------------
#include <stdio.h>
#include <stdlib.h>

int main(void){

    int i;
    int n;
    int head = 0;
    int mid = 0;
    int rear = 1;

    printf("\n피보나치 수 입력 :");
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        printf("%d", head );
        mid = head+rear;
        head = rear;
        rear = mid ;
    }

    printf("\n\n");
    system("pause");
    return 0;
}
