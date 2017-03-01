#include <stdio.h>
#include<stdlib.h>

typedef struct list_el{
    int key;
    struct list_el* next;


}*list_element;

typedef list_element* list;

list creat(){

char ch;
int start=NULL;
do{
struct list_el *new_node,*current;
new_node=(struct list_el *)malloc(sizeof(struct list_el));

printf("\nEnter the data : ");
scanf("%d",&new_node->key);
new_node->next=NULL;

if(start == NULL) {
   start = new_node;
   current = new_node;
}

else
    {
    current->next = new_node;
    current = new_node;
    }

    printf("\nDo you want to create another(y/n): ");
 ch=getche();
 }while(ch!='n');
 return(list);

}

void display(struct elemento *p)
{
   printf(“nlista —> “);

   /* ciclo di scansione */
   while(p != NULL)
   {
      printf(“%d”, p->inf); // visualizza l’informazione
      printf(” —> “);
      p = p->pun; // scorre di un elemento
   }

   printf(“NULLnn”);
}

int main(){

    creat();
    display(creat());

    return 0;
}

