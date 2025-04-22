# DoodleApp Android

**DoodleApp** es una app de dibujo para Android inspirada en *Amberdraw* (iOS). Está siendo desarrollada en **Kotlin** utilizando **Android Studio** y tiene como objetivo ofrecer una experiencia de dibujo única y artística, con pinceles animados y efectos especiales al estilo de *Amberdraw*.

## ✔️ Características implementadas

- ✏️ Herramienta de lápiz con capacidad de cambio de tamaño.
- 🧽 Herramienta de borrador funcional, que utiliza `Bitmap` y `PorterDuffXfermode` para borrar píxeles reales del lienzo.
- 🎨 Selección de color mediante una rueda visual usando **Skydoves ColorPickerView**.
- 👁️ Visualización en tiempo real del color actual.

## 🚧 Funcionalidades en desarrollo o pendientes

### 🖌️ Sistema de pinceles personalizados

Se está desarrollando un sistema de pinceles que permita efectos visuales únicos en los trazos. La idea es que cada pincel no solo dibuje, sino que anime el trazo de forma especial según su tipo.

#### Tipos de pinceles deseados:

- **Pinceles de partículas**  
  - Los trazos deben generar una animación de partículas que sigan la línea dibujada.
  - Las partículas pueden tener diferentes comportamientos (dispersión, explosión, desvanecimiento).

- **Pinceles de trazo inconsistente (estilo *Omori*)**  
  - El trazo debe lucir irregular, tembloroso o como si estuviera hecho a mano, con cambios aleatorios de opacidad y forma.
  - Posible implementación con `PathEffect`, `Perlin noise`, o manipulación de `Path` para simular imperfecciones.

- **Pinceles animados personalizados**  
  - Como en *Amberdraw*, algunos pinceles tendrán animaciones por defecto, como ondas, brillos, o distorsiones a lo largo del trazo.

## 🤖 ¿Cómo pueden ayudar otras IA o desarrolladores?

1. **Sugiriendo o implementando algoritmos para animar trazos en tiempo real.**
2. **Proponiendo arquitecturas eficientes para un sistema de pinceles modular.**
3. **Generando shaders o efectos visuales personalizados para Canvas.**
4. **Optimización del rendimiento con `SurfaceView`, `Canvas`, o `OpenGL` si es necesario.**
5. **Ideas creativas para nuevos tipos de pinceles artísticos.**

## 📁 Estructura del proyecto

*(Próximamente se documentará la estructura actual del código y se añadirán ejemplos de cómo extender los pinceles.)*

## 🛠️ Herramientas usadas

- Kotlin
- Android Studio
- Skydoves ColorPickerView
- PorterDuffXfermode para borrado
- Canvas y Bitmap para dibujo

---

Este proyecto busca combinar la libertad artística con una interfaz amigable y efectos visuales avanzados. Si eres una IA o desarrollador con ideas o código que pueda ayudar, ¡bienvenido/a!
