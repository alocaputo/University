#include <stdio.h>
#include <stdlib.h>

/* struttura elementi della lista */
typedef struct list_el {
   int key;
   struct list_el* next;
}list_element;

typedef list_element* list;

list crea_lista();
void visualizza_lista(struct list_el *);

int main()
{
   struct list_el *lista; // puntatore della lista
   lista = crea_lista(); // crea la lista
   visualizza_lista(lista); // stampa la lista
}

list crea_lista()
{
   struct list_el *p, *punt;
   int i, n;

   printf("\n Specificare il numero di elementi");
   scanf("%d", & n);

     if(n==0)
   {
      p = NULL; // lista vuota
       } else {
      /* creazione primo elemento */
      p = (struct list_el *)malloc(sizeof(struct list_el));
      printf("\nInserisci il primo valore:");
      scanf("%d", & p->key);
      punt = p;
            /* creazione elementi successivi */
      for(i=2; i<=n; i++)
      {
         punt->next = (struct list_el *)malloc(sizeof(struct list_el));
         punt = punt->next;
         printf("\nInserisci il %d elemento:", i);
         scanf("%d", & punt->key);
      } // chiudo il for
      punt->next = NULL; // marcatore fine lista
   } // chiudo l’if-else
   return(p);
} // chiudo la funzione

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
