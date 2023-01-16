// ReactNativeDeviceRisk.m

#import "ReactNativeDeviceRisk.h"
#import <FraudForce/FraudForce.h>


@implementation ReactNativeDeviceRisk

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(sampleMethod:(NSString *)stringArgument numberParameter:(nonnull NSNumber *)numberArgument callback:(RCTResponseSenderBlock)callback)
{
    // TODO: Implement some actually useful functionality
    callback(@[[NSString stringWithFormat: @"numberArgument: %@ stringArgument: %@", numberArgument, stringArgument]]);
}

RCT_REMAP_METHOD(blackbox, resolver: (RCTPromiseResolveBlock)resolve
     rejecter:(RCTPromiseRejectBlock)reject)
{
  resolve(FraudForce.blackbox);
}


@end
