#include <stdio.h>
#include <stdlib.h>

/* struttura elementi della lista */
typedef struct list_el {
   int key;
   struct list_el *next;
}list_element;

typedef list_element *list;

list crea_lista();


void visualizza_lista(struct list_el *);
void tocircular(struct list_el *);
void display(struct list_el *);
int findCircular(struct list_el *head);

int main()
{
int c;
   struct list_el *lista; // puntatore della lista
   lista = crea_lista(); // crea la lista
   visualizza_lista(lista); // stampa la lista
   printf("\nRendere la lista circolare? (1/0) ");
  scanf("%d", &c);
   if(c==1){
   tocircular(lista);
   display(lista);
   }else{
   }
   findCircular(lista);

}


list crea_lista()
{
   struct list_el *p, *punt;
   int i, n;

   printf("\n Specificare il numero di elementi: ");
   scanf("%d", & n);

     if(n==0)
   {
      p = NULL; // lista vuota
       } else {
      /* creazione primo elemento */
      p = (struct list_el *)malloc(sizeof(struct list_el));
      printf("\nInserisci il primo valore: ");
      scanf("%d", & p->key);
      punt = p;
            /* creazione elementi successivi */
      for(i=2; i<=n; i++)
      {
         punt->next = (struct list_el *)malloc(sizeof(struct list_el));
         punt = punt->next;
         printf("\nInserisci il %d elemento: ", i);
         scanf("%d", & punt->key);
      } // chiudo il for
      punt->next = NULL; // marcatore fine lista
   } // chiudo l’if-else
   return(p);
} // chiudo la funzione

void tocircular(struct list_el *list)
{
    struct list_el *rear;

    rear = list;
    while (rear->next != NULL)
    {
        rear = rear->next;
    }
    rear->next = list;
    /*After this the singly linked list is now circular*/
}

int findCircular(struct list_el *head)
{
   struct list_el *slower, * faster;
   slower = head;
   faster = head->next; //start faster one node ahead
   while(1) {

     // if the faster pointer encounters a NULL element
     if( !faster || !faster->next)
       return -1;
    //if faster pointer ever equals slower or faster's next
    //pointer is ever equal to slow then it's a circular list
     else if (faster == slower || faster->next == slower)
        return 1;
     else{
       // advance the pointers
        slower = slower->next;
        faster = faster->next->next;
      }
   }
}

void display(struct list_el *head)
{
    struct list_el *temp = head;
    printf("Lista:\n");
    printf("%d->", temp->key);
    temp = temp->next;
    while (head != temp)
    {
        printf("%d->", temp->key);
        temp = temp->next;
    }
    printf(" and back to %d->%d->...\n", temp->key, temp->next->key);
}


void visualizza_lista(list p)
{
   printf("\nlista: ");

   /* ciclo di scansione */
   while(p != NULL)
   {
      printf("%d", p->key); // visualizza l’informazione
      printf("->");
      p = p->next; // scorre di un elemento
   }

   printf("NULL\n\n");
}
