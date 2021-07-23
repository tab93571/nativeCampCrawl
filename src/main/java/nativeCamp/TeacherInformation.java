package nativeCamp;

import java.util.HashMap;
import java.util.Map;

public enum TeacherInformation {


    JELENA(39784,"Jelena","I like her" ),
    ARIEL(17662,"Ariel","young girl from Albania"),
    SINDI(20307,"Sindi","Albania uni student"),
    BEE(27935,"Bee","Filipino medical student"),
    MINA(39063,"Mina","haven't got her class yet"),
    EDON(33436,"Edon","Filipino he has a student from 台中 "),
    JULIANA(12068,"Juliana","Nigerian with perfect pronunciation "),
    KATE(43702,"Kate","flight attendant"),
    AALIA(23231,"Aalia","Indian girl, a bit serious"),
    GRAACIOUS(41743,"Graacious","black pretty teacher"),
    ZOKA(44398,"Zoka","Serbian not suitable for daily news"),
    SIMS(19070,"Sims","South African with perfect pronunciation "),
    KARL(24381,"Karl","Filipino works in the bank");

    private static Map<Integer,String> teacherMap = new HashMap();

    TeacherInformation(Integer teacherID,String teacherName,String teacherInformation){
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.teacherInformation = teacherInformation;
    }

    static {
        createTeacherMap();
    }

    public static void createTeacherMap(){

        for(TeacherInformation i:TeacherInformation.values()){
            teacherMap.put(i.getTeacherID(),i.getTeacherName());
        }

    }


    private Integer teacherID;

    private String teacherName;

    private String teacherInformation;


    public Integer getTeacherID() {
        return teacherID;
    }

    public String getTeacherName() { return teacherName; }

    public String getTeacherInformation() { return teacherInformation; }

    public static Map<Integer,String> getTeacherMap(){
        return teacherMap;
    }

}

