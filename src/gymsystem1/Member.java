/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gymsystem1;

/**
 *
 * @author t00130990
 */
public class Member extends Person {
    private static final String DEFAULT_STRING = "Unassigned";
    private static final int DEFAULT_INT = 0;
    private static final double DEFAULT_DOUBLE = 0.0;

    private static int nextMemID = 1;

    private int memberID;
    private String memberAddress;
    private int memberPhoneNo;
    private String memberEmail;
    private String memberType;
    private double membershipPrice;
    private String startDate;
    private String finishDate;

    public Member() {
        this(DEFAULT_STRING, DEFAULT_INT, 'U', DEFAULT_STRING, DEFAULT_INT, DEFAULT_STRING, "Unknown", DEFAULT_DOUBLE,
                DEFAULT_STRING, DEFAULT_STRING);
    }

    public Member(String name, int age, char gender, String address, int phone, String email, String memType,
            double memPrice, String startDate) {
        this(name, age, gender, address, phone, email, memType, memPrice, startDate, DEFAULT_STRING);
    }

    public Member(String nm, int a, char g, String addr, int pNo, String eml, String memTyp, double memPrice,
            String sDate, String fDate) {
        super(nm, a, g);
        this.memberID = getNextMemID();
        this.memberAddress = addr;
        this.memberPhoneNo = pNo;
        this.memberEmail = eml;
        this.memberType = memTyp;
        this.membershipPrice = memPrice;
        this.startDate = sDate;
        this.finishDate = fDate;
    }

    public Member(String nm, int memID) {
        super(nm);
        this.memberID = memID;
        nextMemID++;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public int getMemberPhoneNo() {
        return memberPhoneNo;
    }

    public void setMemberPhoneNo(int memberPhoneNo) {
        this.memberPhoneNo = memberPhoneNo;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public double getMembershipPrice() {
        return membershipPrice;
    }

    public void setMembershipPrice(double membershipPrice) {
        this.membershipPrice = membershipPrice;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return "\n" + super.toString() +
                "\nMember ID: " + getMemberID() +
                "\nMember Address: " + getMemberAddress() +
                "\nMember Phone No: " + getMemberPhoneNo() +
                "\nMember Email: " + getMemberEmail() +
                "\nMembership Type: " + getMemberType() +
                "\nMembership Price: " + getMembershipPrice() +
                "\nMembership Start Date: " + getStartDate() +
                "\nMembership Finish Date: " + getFinishDate();
    }

    public static int getNextMemID() {
        return nextMemID++;
    }

    public static void setNextMemID(int nextMemID) {
        Member.nextMemID = nextMemID;
    }
}
