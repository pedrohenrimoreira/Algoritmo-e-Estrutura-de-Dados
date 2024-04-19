#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>


bool isVogal(char fra[1000]){
    for(int i=0;fra[i]!='\0';i++){
        if(fra[i]!=65&&fra[i]!=69&&fra[i]!=73&&fra[i]!=79&&fra[i]!=85&&fra[i]!=97&&fra[i]!=101&&fra[i]!=105&&fra[i]!=111&&fra[i]!=117){
            return false;
        }
        }
    return true;
}

bool isConsoante(char fra[1000]){
    for(int i=0;i<strlen(fra);i++){
        for(int a=65;a<=90;a++){
            if(fra[i]==65||fra[i]==69||fra[i]==73||fra[i]==79||fra[i]==85||fra[i]==97||fra[i]==101||fra[i]==105||fra[i]==111||fra[i]==117){
                return false;
            }
            else if(fra[i]==a){
                a=90;
            }
            else if(fra[i]>=97&&fra[i]<=122){
                a=90;
            }
            else{
                return false;
            }
        }
                
    }
    return true;
}

bool isInt(char fra[1000]){
    for(int i=0;i<strlen(fra);i++){
        if(fra[i]>=48&&fra[i]<=57){
        }
        else{
            return false;
        }
    }
    return true;
}

bool isReal(char fra[1000]){
    int ponto=0;
    for(int i=0;i<strlen(fra);i++){          
        if(fra[i]>=48&&fra[i]<=57){
        }
        else if((fra[i]==46||fra[i]==44)&&ponto==0){                   
            ponto++;
        }
        else{
            return false;
        }
    }
    return true;
}

typedef struct Palavras{
    char frase[1000];
}Palavras;

int main(void){
    Palavras posicao[1000];
    int i=0;
    bool X1[1000], X2[1000], X3[1000], X4[1000];
    scanf(" %[^\n]",posicao[i].frase);
    while((posicao[i].frase[0]=='F'&&posicao[i].frase[1]=='I'&&posicao[i].frase[2]=='M'&&posicao[i].frase[3]=='\0')==false){
        X1[i]=isVogal(posicao[i].frase);
        X2[i]=isConsoante(posicao[i].frase);
        X3[i]=isInt(posicao[i].frase);
        X4[i]=isReal(posicao[i].frase);
        i++;
        scanf(" %[^\n]",posicao[i].frase);
    }
    for(int x=0;x<i;x++){
        if(X1[x]==true){
            printf("SIM ");
        }
        else{
            printf("NAO ");
        }
        if(X2[x]==true){
            printf("SIM ");            
        }
        else{
            printf("NAO ");
        }            
        if(X3[x]==true){
            printf("SIM ");
        }
        else{
            printf("NAO ");
        }
        if(X4[x]==true){
            printf("SIM");
        }
        else{
            printf("NAO");
        }
        printf("\n");
    }
}