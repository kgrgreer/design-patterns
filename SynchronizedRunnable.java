
  public class RunnableProxy
      implements Runnable
  {

    protected Runnable delegate;

    public RunnableProxy(Runnable delegate) {
      this.delegate = delegate
    }

    public void run() {
      this.delegate.run();
    }
  }


  public class SynchronizedRunnable
      extends RunnableProxy
  {

    public SyncronizedRunnable(Runnable delegate) {
      super(delegate);
    }

    synchronized public void run() {
      this.delegate.run();
    }
  }

  public class SynchronizedMyRunnable
      extends MyRunnable
  {

    public SyncronizedMyRunnable() {
    }

    synchronized public void run() {
      this.super();
    }
  }

  Runnable r = new SynchronizedRunnable(new MyRunnable());
  Runnable r = new SynchronizedMyRunnable();


  public class PrototypeFactory
      implements Factory
  {
    protected Object prototype;

    public PrototypeFactory(Object prototype) {
      this.prototype = prototype;
    }

    public Object create() {
      return prototype.clone();
    }
  }


  public class SingletonFactory
      implements Factory
  {
    protected Factory factory;
    protected Object  instance;

    public PrototypeFactory(Factory factory) {
      this.factory = factory;
    }

    public synchronized Object create() {
      if ( this.factory ) {
        this.instance = this.factory.create();
        this.factory  = null;
      }

      return this.instance;
    }
  }
