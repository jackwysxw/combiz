package combiz.domain.location;



/**
 * Loceqrelation generated by MyEclipse - Hibernate Tools
 */

public class Loceqrelation  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String location;
     private String systemid;
     private String reltype;
     private String eqnum;


    // Constructors

    /** default constructor */
    public Loceqrelation() {
    }

    
    /** full constructor */
    public Loceqrelation(String location, String systemid, String reltype, String eqnum) {
        this.location = location;
        this.systemid = systemid;
        this.reltype = reltype;
        this.eqnum = eqnum;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }

    public String getSystemid() {
        return this.systemid;
    }
    
    public void setSystemid(String systemid) {
        this.systemid = systemid;
    }

    public String getReltype() {
        return this.reltype;
    }
    
    public void setReltype(String reltype) {
        this.reltype = reltype;
    }

    public String getEqnum() {
        return this.eqnum;
    }
    
    public void setEqnum(String eqnum) {
        this.eqnum = eqnum;
    }
   








}