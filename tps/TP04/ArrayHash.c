#include <stdio.h>
#include <string.h>

int main() {
    int casos, qtsLinhas;
    int i, qtsCaso;
    int qtsLetra;
    int somaLetras;

    char string[60];

    scanf("%d", &casos);

    while (casos--) {
        scanf("%d", &qtsLinhas);

        qtsCaso = 0;
        somaLetras = 0;
        while (qtsLinhas--) {
            scanf(" %s", string);

            i = 0;
            qtsLetra = 0;

            while (string[i]) {
                somaLetras += (string[i] - 'A') + qtsCaso + qtsLetra++;

                i++;
            }

            qtsCaso++;

            memset(string, 0, sizeof(string));
        }

        printf("%d\n", somaLetras);
    }

    return 0;
}
