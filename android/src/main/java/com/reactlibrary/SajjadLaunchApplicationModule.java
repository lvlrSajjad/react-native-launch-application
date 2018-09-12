
package com.reactlibrary;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.view.WindowManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import static android.content.Context.POWER_SERVICE;

public class SajjadLaunchApplicationModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public SajjadLaunchApplicationModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "SajjadLaunchApplication";
  }

  @ReactMethod
  public void open(String PackageName) {
    PowerManager.WakeLock screenLock = ((PowerManager) getReactApplicationContext().getSystemService(POWER_SERVICE)).newWakeLock(
            PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "TAG");
    screenLock.acquire();

    screenLock.release();
    KeyguardManager km = (KeyguardManager) getReactApplicationContext().getSystemService(Context.KEYGUARD_SERVICE);
    final KeyguardManager.KeyguardLock kl = km.newKeyguardLock("MyKeyguardLock");
    kl.disableKeyguard();

  //  Intent dialogIntent = new Intent(getReactApplicationContext(), MainActivity.class);
    Intent dialogIntent = getReactApplicationContext().getPackageManager().getLaunchIntentForPackage(PackageName);

    dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    dialogIntent.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED +
            WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD +
            //      WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON +
            WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
    getReactApplicationContext().startActivity(dialogIntent);
  }
}