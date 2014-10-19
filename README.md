PlasmaUI
========

Android animation made simple.

![PlasmaUI](/../github-media/media/presentation.gif?raw=true)

PlasmaUI is an animation library that lets you animate your view by simply adding code to your layout file (as little as you want it to be). No need to create extra xml files or write any Java code to get you animations up and running. Let the animations be where they should. Of course, you can still trigger animations inside your Java classes. 
There is a demo application in the source code to see it move, and you can check the guide below.

##Features

* Animation declaration inside layout files
* Support for consecutive or parallel animations in the same view
* Customizable duration, delay, distance, direction and rotation
* Auto play
* Recursive view hierarchy animation execution

##Animation types

The library currently supports this animation types:

`Bounce`,`FadeIn`,`FadeOut`,`Move`,`Pop`,`RotateIn`,`RotateInPlace`,`RotateOut`,`Shake`,`Slide`,`ZoomIn`,`ZoomOut`

##Usage

To create an animation, first go into your layout file and define a xml namespace alias to the library:

``` xml
xmlns:custom="http://schemas.android.com/apk/res-auto"
```

You can choose the alias you want, instead of `custom`.
Then, encapsulate the view (or views) you wish to animate with the PlasmaView component

``` xml
<gmk.kwl.plasmaui.view.PlasmaView
custom:animation="pop" >
	<View android:id="@+id/your_view" />
</gmk.kwl.plasmaui.view.PlasmaView>
```

And that's it! your view should now automatically animate when loaded.
Note that we added the `animation` attribute to the PlasmaView to specify the animation type. This is the minimum required attribute to actually perform an animation. (Other attributes are initialized with default values)

###PlasmaView attributes

The `PlasmaView` supports the following attributes: `animation`,`duration`,`delay`,`distance`,`auto`,`keepData`. They will be explained below.

####Attribute: animation

The `animation` attribute is used to define the animation type (not case sensitive) of the view. This is the only required attribute when creating an animation. More advanced features of the attribute will be described in sections below.
Animation types can have additional properties set, most of them are optional. This includes `direction`, `rotation` and `translation`. Properties are added with a `:` next to the animation name.

#####Direction

Direction can be `left`, `right`, `up` or `down`.
Supported animation types: `Bounce`(For this animation it is required or it won't bounce),`FadeIn`,`FadeOut`,`Pop`,`Slide`,`ZoomIn`,`ZoomOut`.
Example:

``` xml
<gmk.kwl.plasmaui.view.PlasmaView
custom:animation="bounce:left" >
```

#####Rotation

Rotation is a number expressed in degrees.
Supported animation types: `RotateIn`, `RotateInPlace`, `RotateOut`.
Example:

``` xml
<gmk.kwl.plasmaui.view.PlasmaView
custom:animation="rotateIn:50" >
```

#####Translation

This property is used only in the animation type `Move`. This is actually required and are two properties: X and Y.
Example:

``` xml
<gmk.kwl.plasmaui.view.PlasmaView
custom:animation="move:30:30" >
```

Unlike directional properties, the `move` animation does modify the final position of the view.

#####No properties

The `shake` animation does not support additional properties.

####Attribute: duration

The `duration` attribute is used to define the duration of the animation. It is defined in `milliseconds`.

####Attribute: delay

The `delay` attribute is used to define the delay before an animation starts. It is defined in `milliseconds`.

####Attribute: distance

The `distance` attribute is used to define the distance of any translation that an animation may have. Note that the value specified is in `Dip` units. For example, if you set:

``` xml
<gmk.kwl.plasmaui.view.PlasmaView
custom:animation="fadein:left"
custom:distance="100" >
```

The translation to the left will cover a distance of 100 dip.

####Attribute: auto

The `auto` attribute defines if the animation will be auto played on load. It is `true` by default.

####Attribute: keepData

The `keepData` attribute defines if the animation object will be kept in memory. It is `true` by default. You can set it to `false` if you won't animate your view later on.

##Advanced usage

Additional operations include: 

* Adding a consecutive animation 
* Adding a parallel animation
* Triggering animations through the Java interface

###Adding a consecutive animation

Adding a consecutive animation requires to add the additional animation next to the first animation separated by a `;`. You can add whitespaces to improve readability, but it will also work without them. Example:

``` xml
<gmk.kwl.plasmaui.view.PlasmaView
custom:animation="fadein:left ; shake"
custom:duration="300 ; 400"
custom:delay="0 ; 300" >
```

Note that if you want to customize the `duration`, `delay` or `distance` you must do the same in the respective attributes separating with a `;`.
The consecutive animation will trigger after the first one is finished. If you add delay (for example 300 ms) it will be applied after the first animation is finished.
You can add more than two consecutive animations, feel free to experiment ;).

###Adding a parallel animation

You may also want to add parallel animations. To do this, separate the animations with a `+`. For `duration`, `delay` and `distance` attributes the separator must still be a `;`. Example:

``` xml
<gmk.kwl.plasmaui.view.PlasmaView
custom:animation="bounce:left + fadein"
custom:delay="100 ; 0" >
```

In this case if you add delay, they both will be applied at the same time (so the fadeIn would kick in first). All animations can be combined, just don't do something too crazy, or it will look weird.

###Triggering animations through the Java interface

After having defined the animations in your layout file, you can trigger them later (for the first time or again) by calling the method `startAnimations(recursive)` on the PlasmaView.

``` java
PlasmaView plasmaView = (PlasmaView)findViewById(R.id.animation_view);
plasmaView.startAnimations(true);
```

If the `recursive` parameter is set to `true` and the plasma view has children views that are also of type `PlasmaView`, their animations will be triggered.

##Future features

* Maven release coming soon!
* Animations extensibility
* Animations automated creation

##Author

All your comments and suggestions are welcome :D

Kevin Wong, [@kevinwl02](https://twitter.com/kevinwl02)

##License

Code distributed under the [MIT license](LICENSE)