LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := UsingNDK
LOCAL_SRC_FILES := UsingNDK.cpp

include $(BUILD_SHARED_LIBRARY)
