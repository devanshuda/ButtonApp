### Summary: Advanced Layouts and Styling in Jetpack Compose

**1\. Building Manual Grids with Column and Row**We moved away from the automated LazyVerticalGrid to explore how to build a grid manually.

*   By nesting three **Row** components (horizontal layout) inside one main **Column** component (vertical layout), we created a static 3x3 grid.
    
*   This approach is ideal for interfaces with a small, fixed number of elements (like a calculator) where scrolling is not required, as it saves system memory.
    

**2\. Exploring Other Core Compose Layouts**We briefly looked at the broader Jetpack Compose layout ecosystem for building full applications:

*   **LazyColumn / LazyRow:** Optimized for long, single-axis scrolling lists (like an Instagram feed).
    
*   **Scaffold:** An "app shell" layout that automatically positions Material Design elements like top bars, bottom navigation, and floating action buttons.
    
*   **ConstraintLayout:** Used for complex screens where elements need to overlap or align relative to one another.
    
*   **BoxWithConstraints:** A responsive layout that allows you to change the UI based on the exact screen width or height at that moment.
    
*   **HorizontalPager / VerticalPager:** Designed for swiping through full-screen pages (like TikTok or tabbed screens).
    

**3\. Achieving Full-Screen, Uniform Proportions**To make the 3x3 grid cover the entire screen with buttons of the exact same size, we introduced the **weight** modifier.

*   **Modifier.weight(1f):** This tells an element to take up an equal fraction of the remaining available space.
    
*   By applying weight(1f) to the three rows, the vertical screen space was divided into perfect thirds.
    
*   By applying weight(1f) to the three buttons inside each row, the horizontal screen space was similarly divided into thirds.
    
*   Coupling this with **Modifier.fillMaxSize()** forced the buttons to visually stretch and fill their allocated blocks, making the layout perfectly responsive to any screen size or rotation.
    

**4\. Customizing Component Shapes**Jetpack Compose uses Material Design 3 by default, which renders standard buttons as heavily rounded ovals or "pills."

*   To change this, we passed a shape parameter directly into the Button component.
    
*   Using **RoundedCornerShape(8.dp)**, we modified the buttons into standard rectangles with subtly curved edges. We also noted that this can be adjusted to 0.dp for sharp corners or customized for each individual corner.