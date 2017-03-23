# HistogramView1.0.1
## 1.简要介绍
  这是一个简单的自定义控件,主要是用来跟随音乐的播放状态,来进行柱状图的波动
  默认样式
  ![image](https://github.com/NamHofstadter/HistogramView/blob/master/app/libs/jdfw.gif)
## 2.使用步骤
#### 1.添加依赖
   ```xml
    compile 'com.namhofstadter.histogramview:histogramview-master:1.0.1'
   ```
#### 2.布局文件中使用
```xml
  <!--android:layout_width="wrap_content" //根据自己需求的大小定义
    android:layout_height="wrap_content" //根据自己需求的大小定义
    ------------------------------------
    //以下三个属性如果不加即展示默认样式
    ------------------------------------
    his:rectColor = "#ff0" //柱状图颜色
    his:space = "0.3" //柱的间距,范围是0-0.99,根据自己需要的视觉效果调整
    his:corner = "15" //柱的圆角效果,单位是像素,如果不需要圆角,设为0即可
    -->
<com.jcenterviews.namhofstadter.histogramview_master.HistogramView
  android:layout_width="wrap_content"  
  android:layout_height="wrap_content"
  his:rectColor = "#ff0"
  his:space = "0.3"
  his:corner = "15"
/>
```
#### 3.代码控制
  1>.控制波动状态
```java
    histogramView.change_Status(false);//停止波动
    histogramView.change_Status(true);//开启波动
```
  2>.代码控制属性
待完善
  
  
  
