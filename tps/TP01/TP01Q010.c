#include <stdio.h>

void ler(FILE *fp, int n) {
    rewind(fp);
    int tam = -4;
    float aux;
    for (int i = 0; i < n; i++) {
        fseek(fp, tam, SEEK_END);
        fread(&aux, sizeof(float), 1, fp);
        printf("%g\n", aux);

        tam -= 4;
    }
}

void escrever(FILE *fp, int n) {
    float num;
    for (int i = 0; i < n; i++) {
        scanf("%f", &num);
        fwrite(&num, sizeof(float), 1, fp);
    }
    ler(fp, n);
}



int main (void) {
    FILE *arquivo = fopen("file.txt", "w+");

    if (arquivo == NULL) {
    printf("Erro na abertura do arquivo!");
    return 1;
  }
 
  // pegar n de linhas
  int n = 0;
  scanf("%d", &n);
  escrever(arquivo, n);
}