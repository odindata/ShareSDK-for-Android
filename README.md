# 奥丁分享、第三方授权登录SDK

- [奥丁ShareSDK官网](http://www.odinanalysis.com/share.html)

## 一、集成说明

### 配置build.gradle

- 项目根目录的build.gradle

```groovy
buildscript {

    repositories {
        ...
        maven { url "http://maven.odinlk.com:58080/repository/android/" }
    }
    dependencies {
       ...
    }
}
allprojects {
    repositories {
       ...
        maven {
            url "http://maven.odinlk.com:58080/repository/android/"
        }
    }
}
```

- module工程的build.gradle


```groovy
//核心SDK的jar包，必不可少
implementation 'com.odin.share:ShareSDK:1.0.3_beta'
//各个平台功能的jar包，按需添加
implementation 'com.odin.share:QQ:1.0.3_beta'
implementation 'com.odin.share:Wechat:1.0.3_beta'
implementation 'com.odin.share:SinaWeibo:1.0.3_beta'
implementation 'com.odin.share:Alipay:1.0.3_beta'
implementation 'com.odin.share:Dingding:1.0.3_beta'
implementation 'com.odin.share:Facebook:1.0.3_beta'
implementation 'com.odin.share:Twitter:1.0.3_beta'
implementation 'com.odin.share:Instagram:1.0.3_beta'
//一键分享UI界面的jar包，按需添加
implementation 'com.odin.share:OdinOneKeyShare:1.0.3_beta@aar'
```



### 配置ShareSDK.xml

- module工程下的assets文件夹下添加ShareSDK.xml各个平台的分享授权配置信息的文件

```xml
<DevInfor>

    <!--  奥丁分享：相关字段说明   -->

    <!--  1、Id:奥丁数据-用户中心-开发者中心统计数据时需要，不可修改  -->
    <!--  2、SortId:一键分享界面，各个平台排版排序使用，可以按需修改  -->
    <!--  3、AppKey、AppId、AppSecret、
             ConsumerKey、ConsumerSecret、
             ClientId、ClientSecret、
             RedirectUrl、RedirectUri和CallbackUrl: 需要去各个平台的开发者中心申请 -->

    <OdinShareSDK
        AppKey=""
        AppSecret="" />
        
    <SinaWeibo
        Id="1"
        SortId="1"
        AppKey=""
        AppSecret=""
        RedirectUrl=""
        Enable="true" />
    <!-- UserName和Path是分享小程序使用，对应小程序的id和path   -->
    <Wechat
        Id="997"
        SortId="2"
        AppId=""
        AppSecret=""
        UserName=""
        Path=""
        WithShareTicket = "true"
        MiniprogramType = "0"
        Enable="true" />
    <WechatMoments
        Id="997"
        SortId="3"
        AppId=""
        AppSecret=""
        Enable="true" />
    <WechatFavorite
        Id="997"
        SortId="4"
        AppId=""
        AppSecret=""
        Enable="true" />
    <QQ
        Id="998"
        SortId="5"
        AppId=""
        AppKey=""
        Enable="true" />
    <QZone
        Id="998"
        SortId="6"
        AppId=""
        AppKey=""
        Enable="true" />
    <Alipay
        Id="993"
        SortId="7"
        AppId=""
        RedirectUri=""
        Enable="true"/>
    <AlipayMoments
        Id="993"
        SortId="8"
        AppId=""
        RedirectUri=""
        Enable="true"/>
    <Dingding
        Id="52"
        SortId="52"
        AppId=""
        AppSecret=""
        Enable="true"/>
    <Facebook
        Id="10"
        SortId="9"
        ConsumerKey=""
        ConsumerSecret=""
        RedirectUrl=""
        Enable="true" />
    <Twitter
        Id="11"
        SortId="10"
        ConsumerKey=""
        ConsumerSecret=""
        CallbackUrl=""
        Enable="true" />
    <Instagram
        Id="15"
        SortId="11"
        ClientId=""
        ClientSecret=""
        RedirectUri=""
        Enable="true" />

</DevInfor>
```



### 配置回调Activity

- 在AndroidManifest.xml文件设置各个平台的回调activity

```xml
<!-- 微信回调的Activity -->
<activity
    android:name="cn.odinshare.wechat.utils.WechatHandlerActivity"
    android:exported="false" />
<activity-alias
    android:name=".wxapi.WXEntryActivity"
    android:exported="true"
    android:targetActivity="cn.odinshare.wechat.utils.WechatHandlerActivity" />


<!-- 支付宝回调的Activity -->
<activity
    android:name="cn.odinshare.alipay.utils.AlipayHandlerActivity"
    android:exported="false" />
<activity-alias
    android:name=".apshare.ShareEntryActivity"
    android:exported="true"
    android:targetActivity="cn.odinshare.alipay.utils.AlipayHandlerActivity" />


<!-- 钉钉回调Activity -->
<activity
    android:name="cn.odinshare.dingding.utils.DingdingHandlerActivity"
    android:exported="false" />
<activity-alias
    android:name=".ddshare.DDShareActivity"
    android:exported="true"
    android:targetActivity="cn.odinshare.dingding.utils.DingdingHandlerActivity" />


<!-- 腾讯QQ和QZone回调的Activity -->
<activity
    android:name="cn.odinshare.qq.qq.QQReceiveActivity"
    android:launchMode="singleTask"
    android:noHistory="true">
    <intent-filter>
        <action android:name="android.intent.action.VIEW" />

        <category android:name="android.intent.category.DEFAULT" />
        <category android:name="android.intent.category.BROWSABLE" />
        <!-- tencent{换成您申请腾讯的appid} -->
        <data android:scheme="tencent101701152" />
    </intent-filter>
</activity>


<!-- 核心的Activity，不可缺少 -->
<activity
    android:name="cn.odinshare.core.OdinUIShell"
    android:configChanges="keyboardHidden|orientation|screenSize"
    android:theme="@android:style/Theme.Translucent.NoTitleBar"
    android:windowSoftInputMode="stateHidden|adjustResize">

    <!-- 新浪微博回调的Activity -->
    <intent-filter>
        <action android:name="com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY" />

        <category android:name="android.intent.category.DEFAULT" />
    </intent-filter>
</activity>
```



### 权限申请

- 请在AndroidManifest中添加如下权限，并申请权限，不然可能会造成分享、授权失败

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.READ_PHONE_STATE" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```



### 混淆设置

- OdinShareSDK已经做了混淆处理，再次混淆会导致不可预期的错误，请在您的混淆脚本中添加如下的配置，跳过对OdinShareSDK的混淆操作

```
-keep class cn.odinshare.**{*;}
-keep class com.sina.**{*;}
-keep class **.R$* {*;}
-keep class **.R{*;}
-dontwarn cn.odinshare.**
-dontwarn com.sina.**
-dontwarn **.R$*
```

## 二、OdinShareSDK的Api说明

### 初始化

```java
/**
 * 初始化，在Application中进行SDK的初始化
 *
 * @param context context
 */
public static synchronized void init(Context context)
```



### 分享

```java
/**
 * 分享
 *
 * @param platformName           分享的平台名称
 * @param shareParams            分享的参数
 * @param platformActionListener 分享的回调事件
 */
public static void doShare(@PlatformNames String platformName, @NonNull Platform.ShareParams shareParams, @Nullable PlatformActionListener platformActionListener)
```



### 一键分享UI界面

```java
 new OneKeyShare()
     			.setUrl(Constant.WEBPAGE_URL)
                .setTitle(Constant.TITLE_TEXT)
                .setText(Constant.TEXT)
                .setImageUrl(Constant.IMAGE_URL)
                .setPlatformActionListener(new OdinPlatformActionListener(activity))
                .show(activity);
```

### 第三方授权登录

```java
/**
 * 授权登录
 *
 * @param platformName           授权登录的平台名称
 * @param platformActionListener 授权登录的回调事件
 */
public static void doAuthorize(@PlatformNames String platformName, @Nullable PlatformActionListener platformActionListener)
```



### 取消授权登录

```java
/**
 * 取消授权登录
 *
 * @param platformName 取消授权登录的平台名称
 */
public static void doAuthorizeCancel(@PlatformNames String platformName)
```



### 判断是否进行过授权登录

```java
/**
 * 是否授权登录过
 *
 * @param platformName 授权登录的平台名称
 * @return true:已经授权登录；false:没有授权登录
 */
public static boolean isAuthValid(@PlatformNames String platformName)
```



### 获取用户信息

```java
/**
 * 授权登录并获取用户信息
 *
 * @param platformName           获取用户信息的平台名称
 * @param platformActionListener 获取用户信息的回调事件
 * @param account                用户的账号Id
 */
public static void doShowUser(@PlatformNames String platformName, @Nullable PlatformActionListener platformActionListener, @Nullable String account)
```