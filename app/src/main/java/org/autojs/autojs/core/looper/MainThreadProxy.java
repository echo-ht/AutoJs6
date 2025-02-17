package org.autojs.autojs.core.looper;

import androidx.annotation.NonNull;

import org.autojs.autojs.runtime.ScriptRuntime;
import org.autojs.autojs.lang.ThreadCompat;
import org.mozilla.javascript.BaseFunction;

import java.util.Map;

/**
 * Created by Stardust on Dec 28, 2017.
 */
public class MainThreadProxy {

    private final Thread mThread;
    private final ScriptRuntime mRuntime;

    public MainThreadProxy(Thread thread, ScriptRuntime runtime) {
        mThread = thread;
        mRuntime = runtime;
    }

    public double setTimeout(BaseFunction callback, long delay, Object... args) {
        return getMainTimer().setTimeout(callback, delay, args);
    }

    private Timer getMainTimer() {
        return mRuntime.timers.getMainTimer();
    }

    public boolean clearTimeout(int id) {
        return getMainTimer().clearTimeout(id);
    }

    public double setInterval(BaseFunction callback, long interval, Object... args) {
        return getMainTimer().setInterval(callback, interval, args);
    }

    public boolean clearInterval(int id) {
        return getMainTimer().clearInterval(id);
    }

    public double setImmediate(BaseFunction listener, Object... args) {
        return getMainTimer().setImmediate(listener, args);
    }

    public boolean clearImmediate(int id) {
        return getMainTimer().clearImmediate(id);
    }

    public static Thread currentThread() {
        return Thread.currentThread();
    }

    public static void yield() {
        Thread.yield();
    }

    public static void sleep(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public static void sleep(long millis, int nanos) throws InterruptedException {
        Thread.sleep(millis, nanos);
    }

    public void start() {
        mThread.start();
    }

    public void run() {
        mThread.run();
    }

    @Deprecated
    public void stop() {
        mThread.stop();
    }

    @Deprecated
    public void stop(Throwable obj) {
        mThread.stop(obj);
    }

    public void interrupt() {
        mThread.interrupt();
    }

    public static boolean interrupted() {
        return ThreadCompat.interrupted();
    }

    public boolean isInterrupted() {
        return mThread.isInterrupted();
    }

    @Deprecated
    public void destroy() {
        mThread.destroy();
    }

    public boolean isAlive() {
        return mThread.isAlive();
    }

    @Deprecated
    public void suspend() {
        mThread.suspend();
    }

    @Deprecated
    public void resume() {
        mThread.resume();
    }

    public void setPriority(int newPriority) {
        mThread.setPriority(newPriority);
    }

    public int getPriority() {
        return mThread.getPriority();
    }

    public void setName(String name) {
        mThread.setName(name);
    }

    public String getName() {
        return mThread.getName();
    }

    public ThreadGroup getThreadGroup() {
        return mThread.getThreadGroup();
    }

    public static int activeCount() {
        return Thread.activeCount();
    }

    public static int enumerate(Thread[] tarray) {
        return Thread.enumerate(tarray);
    }

    @Deprecated
    public int countStackFrames() {
        return mThread.countStackFrames();
    }

    public void join(long millis) throws InterruptedException {
        mThread.join(Math.max(0, millis));
    }

    public void join(long millis, int nanos) throws InterruptedException {
        mThread.join(Math.max(0, millis), Math.max(0, nanos));
    }

    public void join() throws InterruptedException {
        mThread.join();
    }

    public static void dumpStack() {
        Thread.dumpStack();
    }

    public void setDaemon(boolean on) {
        mThread.setDaemon(on);
    }

    public boolean isDaemon() {
        return mThread.isDaemon();
    }

    public void checkAccess() {
        mThread.checkAccess();
    }

    public ClassLoader getContextClassLoader() {
        return mThread.getContextClassLoader();
    }

    public void setContextClassLoader(ClassLoader cl) {
        mThread.setContextClassLoader(cl);
    }

    public static boolean holdsLock(Object obj) {
        return Thread.holdsLock(obj);
    }

    public StackTraceElement[] getStackTrace() {
        return mThread.getStackTrace();
    }

    public static Map<Thread, StackTraceElement[]> getAllStackTraces() {
        return Thread.getAllStackTraces();
    }

    public long getId() {
        return mThread.getId();
    }

    public Thread.State getState() {
        return mThread.getState();
    }

    @NonNull
    @Override
    public String toString() {
        return mThread.toString();
    }

    public static void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler eh) {
        Thread.setDefaultUncaughtExceptionHandler(eh);
    }

    public static Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() {
        return Thread.getDefaultUncaughtExceptionHandler();
    }

    public Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return mThread.getUncaughtExceptionHandler();
    }

    public void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler eh) {
        mThread.setUncaughtExceptionHandler(eh);
    }
}
