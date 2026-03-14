# Práctica Integrada: Biblioteca con Bugs

## Instrucciones Especiales
Esta práctica combina **depuración** y **control de versiones**. Para cada bug:

1. **IDENTIFÍCALO** con el debugger de VS Code
2. **DOCUMÉNTALO** en Issues de GitHub
3. **CREA UN TEST** que lo reproduzca
4. **CORRÍGELO** en un commit separado
5. **VERIFICA** que tu test ahora pasa

## Bugs Conocidos (¡No mires si quieres el desafío!)
<!-- Esto está oculto en detalles -->
<details>
<summary>Lista de bugs (SPOILER)</summary>

1. Libros duplicados permitidos
2. Búsqueda sensible a mayúsculas/minúsculas
3. Puedes prestar un libro ya prestado
4. Puedes devolver un libro ya disponible
5. Listado de disponibles muestra todos
6. Falta método para quitar libros
7. Faltan getters importantes
</details>

## Evidencias Requeridas
Para cada bug, incluir en el PR:
- [ ] Screenshot del breakpoint
- [ ] Screenshot de variables en el momento del error
- [ ] Enlace al issue correspondiente
- [ ] Código del test que lo reproduce

## Estructura del repositorio
```bash
/E2-library-buggy/
├── README.md
├── .gitignore      # Archivos a ignorar (localizado en un directorio superior) 
├── Main.java       # Punto de entrada
├── Book.java
├── Library.java
├── E2-Full_Stack_Developer-Debug+Git.pdf
└── /documentacion/    # Para las capturas de pantalla, entre otras las del debugger
```
