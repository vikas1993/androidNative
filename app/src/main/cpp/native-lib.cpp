#include <jni.h>
#include <string>
#include <android/log.h>


extern "C" JNIEXPORT jstring

JNICALL
Java_vikas_myapplication_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jint JNICALL
Java_vikas_myapplication_MainActivity_sumTwoVString(JNIEnv *env, jobject instance, jint a, jint b) {

    // TODO

    return  (a+b);

}

static jlong fib(jlong n){
    return n <=0 ? 0:n==1?1: fib(n-1)+fib(n-2);
}
extern "C"
JNIEXPORT jlong JNICALL
Java_vikas_myapplication_FibLib_fibNR(JNIEnv *env, jclass type, jlong n) {

    // TODO
    __android_log_print(ANDROID_LOG_DEBUG,"Log from C++ ","fibNR(%lld)",n);
    return fib(n);
}