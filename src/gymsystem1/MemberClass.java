package gymsystem1;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberClass implements Serializable {
    private Member memberName;
    private Class className;
    private String date;
    private double rate;

    // Constantes
    private static final String DEFAULT_DATE = "no date";
    private static final double DEFAULT_RATE = 0.0;

    public MemberClass() {
        this(new Member(), new Class(), DEFAULT_DATE, DEFAULT_RATE);
    }

    public MemberClass(Member member, Class mClass) {
        this(member, mClass, DEFAULT_DATE, DEFAULT_RATE);
    }

    public MemberClass(Member member, Class mClass, String date, double rate) {
        this.memberName = member;
        this.className = mClass;
        this.date = date;
        this.rate = rate;
    }

    public String toString() {
        return "\n\nMember: " + memberName + "\nClass: " + className +
                "\nClass Date: " + getDate() +
                "\nRate: " + rate;
    }

    public String getDate() {
        return date;
    }

    public Member getMember() {
        return memberName;
    }

    public Class getMClass() {
        return className;
    }

    public double getRate() {
        return rate;
    }

}