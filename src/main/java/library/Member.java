package library;

public class Member {

	
	
	
	
	
	



    private int memberNumber;
    private String name;

    public Member(int memberNumber, String name) {
        this.memberNumber = memberNumber;
        this.name = name;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Member number: " + memberNumber
                + ", Name: " + name;
    }
}

