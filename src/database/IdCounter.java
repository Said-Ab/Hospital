package database;

public class IdCounter {
    public static Long ho=0L;
    public static Long de=0L;
    public static Long doc=0L;
    public static Long pat=0L;
    public static Long hospitalId(){
return ++ho;
    }
    public static Long departmentId(){
        return ++de;
    }
    public static Long doctorId(){
        return ++doc;
    }
    public static Long patientId(){
        return ++pat;
    }
}
