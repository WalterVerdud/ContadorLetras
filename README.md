Ejecución:

1. Colocar el texto a procesar en texto.txt
2. Ejecutar la clase contFrecuenciaLetras
3. El programa mostrará:
    - Cantidad total de palabras
    - Cantidad total de caracteres
    - Histograma de frecuencias ordenado


Explicacion del Algoritmo.

Leo el archivo completo, cuento los caracteres excluyendo los saltos de línea, normalizo el texto pasando todas las palabras a minúsculas y las divido usando espacios en blanco. Luego utilizo un HashMap para almacenar la frecuencia de cada palabra en tiempo constante promedio. Finalmente ordeno las entradas del mapa por frecuencia descendente y, en caso de empate, alfabéticamente, para construir el histograma solicitado. La complejidad temporal es O(n + k log k) y el espacio utilizado es O(k), donde k es el número de palabras distintas.