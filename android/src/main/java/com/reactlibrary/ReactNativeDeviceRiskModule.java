// ReactNativeDeviceRiskModule.java

package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import com.iovation.mobile.android.FraudForceConfiguration;
import com.iovation.mobile.android.FraudForceManager;

public class ReactNativeDeviceRiskModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public ReactNativeDeviceRiskModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "ReactNativeDeviceRisk";
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some actually useful functionality
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }

    @ReactMethod
    public void blackbox(final Promise promise) {
        FraudForceConfiguration fraudForceConfiguration = new FraudForceConfiguration.Builder()
            .build();

        FraudForceManager fraudForceManager = FraudForceManager.getInstance();
        fraudForceManager.initialize(fraudForceConfiguration, getReactApplicationContext());

        String blackbox = fraudForceManager.getInstance().getBlackbox(getReactApplicationContext());
        promise.resolve(blackbox);
    }
}
