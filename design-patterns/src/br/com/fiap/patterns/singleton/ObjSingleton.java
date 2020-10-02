package br.com.fiap.patterns.singleton;

public class ObjSingleton {

    public static ObjSingleton instance;

    private ObjSingleton() {
        System.out.println("Objeto criado com sucesso.");
    }

    public static synchronized ObjSingleton getInstance() {
        if(instance == null) instance = new ObjSingleton();
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}
