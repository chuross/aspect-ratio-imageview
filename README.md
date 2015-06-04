#AspectRatioImageView
This ImageView is adjusted auto by aspect ratio.

![](http://img.youtube.com/vi/Mzf7YqLeWEQ/0.jpg)

[demo movie](https://www.youtube.com/watch?v=Mzf7YqLeWEQ)

# Usage
see sample project

Basically, This library can use as ImageView.

If you need to adjust by aspect ratio,Add attributes to your layout in this way.

```
<dev.chuross.library.AspectRatioImageView
    android:id="@+id/img_aspect_image_8"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:ariv_widthRatio="16"
    app:ariv_heightRatio="9" />
```

# Download

```
repositories {
    maven {
        url 'http://chuross.github.com/maven-repository/'
    }
}

dependencies {
    compile 'dev.chuross:aspect-ratio-imageview:1.0.2'
}
```

# License

```
Copyright 2015 chuross

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
