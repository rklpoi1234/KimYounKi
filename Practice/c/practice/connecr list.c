#include <stdio.h>
#include <stdlib.h>

typedef struct node //연결 리스트의 기본 단위가 되는 node 구조체를 정의합니다.
{
    int number; //node안에서 정수형 값이 저장되는 변수를number으로 지정
    struct node*next; //다음node의 주소를 가리키는 포인터를 *next로 지정합니다.
} node;

int main(void)
{
    //list라는 이름의 노드 포인터를 정의.연결 리스트의 가장 첫 번째 node를 가리킬것
    //이 포인터는 현재 아무 것도 가리키고 있지않기 때문에 NULL로 초기화
    node*list = NULL;
    //새로운 node를 위해 메모리를 할당하고 포인터*n으로 가리킵니다.
    node*n = malloc(sizeof(node));

    if( n == NULL)
    {
        return 1;
    }
    
    //n의 넘퍼필드에 1의값을저장 n->number는 (*n).number와동일한의미
    //즉,n이 가리키는 노드의 넘버필드를 의미하는 것입니다.
    //간단하게 화살표 표시 ->로 쓸수있음 n의number의 값을 1로 저장
    n->number = 1;
    //n다음에 정의된 노드가 없으므로 NULL로 초기화합니다.
    n->next = NULL;
    //이제 첫번째 노드를 정의했기 때문에 list포인터를n포인터로 바꿔 줍니다.
    list = n;
    //이제 list에 다른 노드를 더 연결하기 위해 n애 새로운 메모리를 다시 할당
    n = malloc(sizeof(node));
    if(n==NULL)
    {
        return 1;
    }
    //n의 넘버와 next의 값을 각각 저장합니다.
    n->number = 2;
    n->next = NULL;

    //리스트가 가리키는 것은 첫번째 노드입니다.
    //이 노드의 다음 노드를 n포인터로 지정합니다.
    list->next = n;
    //다시 한번 n 포인터에 새롱누 메모리를 할당하고 넘버와 next의값을 저장
    n=malloc(sizeof(node));
    if(n==NULL)
    {
        return 1;
    }
    n->number=3;
    n->next = NULL;
    //list는 첫번째노드를 가리키고,이는 두번째 노드와 연결되어 있습니다.
    //따라서 세번째 노드를 더연결하기 위해 첫번째 node(list)의
    //다음 node(list->next)의 다음 node(lsit->next->next)를 n포인터로 지정합니다.
    list->next->next = n;

    //이제 list에 연결된 노드를 처음부터 방문하면서 각 넘버값을 출력합니다.
    //마지막 노드의 next에느 NULL이 저장되어 있을 것이기 때문에 이것이 for 루프의
    //종료 조건이 됨

    for(node*tmp = list;tmp!=NULL;tmp=tmp->next)
    {
        printf("%i\n",tmp->number);
    }

    //메모리를 해제해주기 위해list에 연결된 노드들을 처음부터 방문함녀서free
    while(list != NULL)
    {
        node*tmp = list->next;
        free(list);
        list = tmp;
    }
}
