#include <jni.h>
#include "com_plter_helloc_HelloC.h"

jint JNICALL Java_com_plter_helloc_HelloC_max
  (JNIEnv *, jobject, jint a, jint b){
	return a>b?a:b;
}
