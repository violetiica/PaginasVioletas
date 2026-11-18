#  PaginasVioletas — Sistema de venta de libros

Aplicación de escritorio en Java para gestionar una librería con libros físicos y digitales. Cuenta con dos perfiles de uso: Vendedor (administra el inventario) y Cliente (explora el catálogo, arma su carrito y realiza la compra).

---

## Funcionalidades

### Perfil Vendedor
- Agregar libros físicos y digitales al inventario.
- Modificar los datos de un libro ya registrado.
- Eliminar (desactivar) libros que ya no están disponibles.
- Ver el inventario completo, con datos de gestión: año de publicación, peso o tamaño, estado y cantidad disponible.
- Cálculo automático del precio de venta a partir del costo y el porcentaje de ganancia indicado.
- Validación de datos: no permite registrar códigos o títulos repetidos y muestra los errores de los campos al usuario.

### Perfil Cliente
- Catálogo separado por libros físicos y libros digitales.
- Carrito de compras con resumen y total.
- Opciones de envío para libros físicos: destino (nacional o internacional) y tipo de envío (normal o urgente), con el costo calculado automáticamente.
- Pantalla de resumen y confirmación de la compra.

---

## Arquitectura

El proyecto sigue el patrón MVC (Modelo – Vista – Controlador) y aplica los pilares de la programación orientada a objetos:

```
LabLibreria/
├── src/
│   ├── Modelo/          # Lógica de negocio y entidades
│   │   ├── Libro.java            (clase abstracta)
│   │   ├── LibroFisico.java      (hereda de Libro)
│   │   ├── LibroDigital.java     (hereda de Libro)
│   │   ├── ListaLibrosFisicos.java
│   │   ├── ListaLibrosDigitales.java
│   │   └── Carrito.java
│   ├── Controller/
│   │   └── Controladora.java     # Conecta las vistas con el modelo
│   ├── Vista/           # Ventanas de la interfaz gráfica (Swing)
│   └── Imagenes/        # Íconos y logo
├── librosFisicos.json   # Inventario de libros físicos
├── librosDigitales.json # Inventario de libros digitales
└── json-simple-1.1.jar  # Librería para leer/escribir JSON
```

Conceptos de POO aplicados
- Abstracción y herencia:** `Libro` es una clase abstracta de la que heredan `LibroFisico` y `LibroDigital`.
- Polimorfismo: cada tipo de libro implementa a su manera `calcularPrecioLibro()`.
- Encapsulamiento: atributos privados con getters y setters.
- Persistencia: el inventario se guarda y se carga desde archivos JSON.

---

## Tecnologías

| Herramienta --- Uso 
| Java 21 --- Lenguaje principal 
| Java Swing --- Interfaz gráfica 
| Apache Ant / NetBeans --- Gestión y compilación del proyecto 
| json-simple 1.1 --- Lectura y escritura de archivos JSON 

---

## Ejecución

### Requisitos
- JDK 21 o superior.
- Apache NetBeans (recomendado, ya que las ventanas fueron diseñadas con su editor visual).

### Pasos
1. Clona el repositorio:
   ```bash
   git clone https://github.com/violetiica/<nombre-del-repositorio>.git
   ```
2. Abre la carpeta del proyecto en NetBeans (`File → Open Project`).
3. Verifica que `json-simple-1.1.jar` esté agregado en las librerías del proyecto (`Properties → Libraries`).
4. Ejecuta la clase principal: `Vista.VentanaClienteVendedor` (`Run → Run Project` o `F6`).
5. En la pantalla de bienvenida elige Vendedor o Cliente.

> Nota: los archivos `librosFisicos.json` y `librosDigitales.json` deben estar en la raíz del proyecto, ya que de ahí se carga el inventario.