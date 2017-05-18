package pexem.domain;
/**
 * 학생을 나타냅니다.
 *
 */
public class Student {

    private Integer sid;
    private String name;
    private String sex;
    private String email;
    public Student(Integer sid, String name, String sex, String email) {
        super();
        this.sid = sid;
        this.sex = sex;
        this.name = name;
        this.email = email;
    }
    
    public Integer getSid() {
        return sid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isGirl() {
    	return sex.equals("F");
    }
    
    public boolean isBoy() {
    	return sex.equals("M");
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sid == null) ? 0 : sid.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (sid == null) {
            if (other.sid != null)
                return false;
        } else if (!sid.equals(other.sid))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "@" + sid + ": " + name + "("+ sex + ")" + email;
    }
    
    
}
