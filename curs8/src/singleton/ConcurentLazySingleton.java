package singleton;

public class ConcurentLazySingleton {

    private static volatile ConcurentLazySingleton instance;

    private ConcurentLazySingleton(){

    }

    public static ConcurentLazySingleton getInstance() {

        if (instance == null){
            synchronized (ConcurentLazySingleton.class) {
                // double check
                if(instance == null) {
                    instance = new ConcurentLazySingleton();
                }

        }

        return instance;
    }
}
