interface Factory { public Object create(); }


  public class SingletonFactory
      implements Factory
  {
    protected Factory factory;
    protected Object  instance;

    public SingletonFactory(Factory factory) {
      this.factory = factory;
    }

    public synchronized Object create() {
      if ( this.factory != null ) {
        this.instance = this.factory.create();
        this.factory  = null;
      }

      return this.instance;
    }
  }
