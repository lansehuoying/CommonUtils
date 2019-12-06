# CommonUtils
```
1.项目根目录build.gradle中添加

dependencies {
        classpath 'com.android.tools.build:gradle:3.2.1'
        //必须
        classpath 'com.hujiang.aspectjx:gradle-android-plugin-aspectjx:2.0.4'
        
    }

allprojects {
		repositories {
			...
      //必须
			maven { url 'https://jitpack.io' }
		}
	}
  
 2. app moudel或者其他moudle build.gradle中添加
  apply plugin: 'android-aspectjx'//必须
  
  
  dependencies {
         //必须
	        implementation 'com.github.lansehuoying:CommonUtils:v1.0'
	}

  3.在需要申请权限的方法上添加注解，例如：
   //激活相册操作（清单文件中也需要添加权限）
    @TimeStatistics("时间统计")
    private void timeStatistics() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    ```
