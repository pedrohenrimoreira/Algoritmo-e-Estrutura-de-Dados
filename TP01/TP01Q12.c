#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

bool isPalin(char s[],int i,int j){
  if(i==j){
    return true;
  }
  else if(i+1==j){
    if(s[i]==s[j]){
      return true;
    }
    else{
      return false;
    }
  }
  else if(s[i]==s[j]){
    return isPalin(s,i+1,j-1);
  }
  else{
    return false;
  }
}

int main(void) {
  char frase[1000];
  scanf(" %[^\n]",frase);
  while(!(frase[0]=='F'&&frase[1]=='I'&&frase[2]=='M'==frase[3]=='\0')){
    if(isPalin(frase,0,strlen(frase)-1)==true){
      printf("SIM\n");
    }
    else{
      printf("NAO\n");
    }
    scanf(" %[^\n]",frase);
  }
}