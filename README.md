Cue
======
Library to create fully customizable Bootstrap styled alerts

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Cue-blue.svg?style=flat)](https://android-arsenal.com/details/1/6722)
[![API](https://img.shields.io/badge/API-9%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=9)
    
Demo
----
![](media/media.gif)
![](media/image.png)

Usage
-----
Add in app build.gradle

```groovy
        allprojects {
            repositories {
                maven {
                    url "https://jitpack.io"
                }
            }
        }
```

Basic usage
```groovy
        Cue.init()
                .with(MainActivity.this)
                .setMessage("This is a sample Toast - Check it out")
                .setType(Type.PRIMARY)
                .show();
```

Types can be
```groovy
    PRIMARY, SUCCESS, SECONDARY, DANGER, WARNING, INFO, LIGHT, DARK, CUSTOM
```

Custom usage
```groovy
        Cue.init()
                .with(MainActivity.this)
                .setMessage("This is a sample Toast - Check it out")
                .setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM)
                .setType(Type.CUSTOM)
                .setDuration(Duration.LONG)
                .setBorderWidth(5)
                .setCornerRadius(10)
                .setCustomFontColor(Color.parseColor("#fd79a8"),
                        Color.parseColor("#ffffff"),
                        Color.parseColor("#e84393"))
                .setFontFace("fonts/custom_font.ttf")
                .setPadding(30)
                .setTextSize(20)
                .setTextGravity(Gravity.CENTER)
                .setHideToast(true)
                .show();
```


Download
--------

 [ ![Download](https://api.bintray.com/packages/fxn769/android_projects/Numpad/images/download.svg) ](https://bintray.com/fxn769/android_projects/Numpad/_latestVersion)  or grab via Gradle:
```groovy
        compile 'com.fxn769:cue:1.1'
```

or Maven:
```xml
        <dependency>
          <groupId>com.fxn769</groupId>
          <artifactId>cue</artifactId>
          <version>1.1</version>
          <type>pom</type>
        </dependency>
```

or ivy:
```xml
        <dependency org='com.fxn769' name='cue' rev='1.1'>
          <artifact name='cue' ext='pom' ></artifact>
        </dependency>
```

Snapshots of the development version are available in [Sonatype's `snapshots` repository][snap].


## License
Licensed under the Apache License, Version 2.0, [click here for the full license](/LICENSE.txt).

## Author & support
This project was created by [Akshay Sharma](https://akshay2211.github.io/).

> If you appreciate my work, consider buying me a cup of :coffee: to keep me recharged :metal: by [PayPal](https://www.paypal.me/akshay2211)

> I love using my work and I'm available for contract work. Freelancing helps to maintain and keep [my open source projects](https://github.com/akshay2211/) up to date!

[![forthebadge](http://forthebadge.com/images/badges/built-for-android.svg)](http://forthebadge.com)


 [snap]: https://oss.sonatype.org/content/repositories/snapshots/



                
