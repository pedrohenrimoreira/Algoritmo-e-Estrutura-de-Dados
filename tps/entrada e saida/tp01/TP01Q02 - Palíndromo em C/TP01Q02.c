#include <string.h>
#include <stdlib.h>
#include <stdio.h>

char verifica(char palindromo[1000]){
  char copia;
  char palin[1000];
  int i, tam, iguais=0;

  tam = strlen(palindromo);

  for(i=0; i<strlen(palindromo); i++)
    {
      palin[i] = palindromo[tam - 1];
      tam--;
    }

  palin[i] = '\0';
  tam = strlen(palindromo);

  for(i=0; i < tam; i++)
    {
      if(palindromo[i] == palin[i])
        iguais++;
    }

    if(tam == iguais)
      copia = 't';
    else
      copia = 'f';

    return copia;
}


int main(void) {

  char frases[10000];
  int a=0, i=0;

  do{
    scanf(" %[^\n]", frases);
    if(strcmp(frases, "FIM") == 0)
    {
      a = 1;
    }
    else if(verifica(frases) == 't')
      printf("SIM\n");
    else
      printf("NAO\n");
    i++;
  }while(a == 0);



  return 0;
}