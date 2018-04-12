# Mobile-Draw_Android
It is a very limited paint-like drawing App for Android. This simple application only allows the user to draw rectangles and ovals.



- The application can be in one of four modes: Select, Rect, Oval, and Erase. Select allows the user to select a pre-existing shape.
Rect allows the user to create a new rectangle. Oval allows creation of new Ovals. Erase allows the user to remove shapes.

- Start the application in Rect mode.

- Shapes will be drawn using a red outline of width 5.0f, unless they are the currently selected shape, in which case they will 
have a blue outline with width 15.0f. They will all be filled in with white. Android canvas painting either allows the outlining 
of a shape, or the filling of a shape, it will only do both at the same time if the fill color and stroke color are the same. 
So to create an outlined and filled shape where the outline is a different color from the filling, you’ll need to draw it twice, 
once with a Paint set to fill and once with a Paint set for just strokes.

- When the application is in Rect or Oval mode, the user can create new shapes by pressing down on one corner of their future shape,
dragging across the screen, and then releasing, thus defining a diagonal line which specifies two opposing corners of the shape. 
This should work for any two diagonally opposite corners, for example dragging from bottom-left to top-right should work just 
as well as top-left to bottom-right.

- The newly created shape will appear on top of all the other shapes. To keep things simple, there is no way to re-order the shapes, 
so newer shapes will always appear on top of older ones.

- In Select mode, if the user taps on a shape, that shape becomes the current selection. If the user taps in the drawing area somewhere 
other than on top of a shape, the selection is cleared (leaving no selection). Taps on the tool selection radio buttons or the 
information text fields below the drawing area don’t have any impact on the selection.



