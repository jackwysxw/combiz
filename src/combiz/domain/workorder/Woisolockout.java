package combiz.domain.workorder;



/**
 * Woisolockout generated by MyEclipse - Hibernate Tools
 */

public class Woisolockout  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String wonum;
     private String isotagid;
     private String isolockid;
     private String description;
     private String location;
     private String eqnum;
     private String eqdescriptioin;
     private String state;
     private Long aplyseq;
     private String perform;


    // Constructors

    /** default constructor */
    public Woisolockout() {
    }

	/** minimal constructor */
    public Woisolockout(String wonum, String isotagid, String isolockid, String description, Long aplyseq) {
        this.wonum = wonum;
        this.isotagid = isotagid;
        this.isolockid = isolockid;
        this.description = description;
        this.aplyseq = aplyseq;
    }
    
    /** full constructor */
    public Woisolockout(String wonum, String isotagid, String isolockid, String description, String location, String eqnum, String eqdescriptioin, String state, Long aplyseq, String perform) {
        this.wonum = wonum;
        this.isotagid = isotagid;
        this.isolockid = isolockid;
        this.description = description;
        this.location = location;
        this.eqnum = eqnum;
        this.eqdescriptioin = eqdescriptioin;
        this.state = state;
        this.aplyseq = aplyseq;
        this.perform = perform;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getWonum() {
        return this.wonum;
    }
    
    public void setWonum(String wonum) {
        this.wonum = wonum;
    }

    public String getIsotagid() {
        return this.isotagid;
    }
    
    public void setIsotagid(String isotagid) {
        this.isotagid = isotagid;
    }

    public String getIsolockid() {
        return this.isolockid;
    }
    
    public void setIsolockid(String isolockid) {
        this.isolockid = isolockid;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }

    public String getEqnum() {
        return this.eqnum;
    }
    
    public void setEqnum(String eqnum) {
        this.eqnum = eqnum;
    }

    public String getEqdescriptioin() {
        return this.eqdescriptioin;
    }
    
    public void setEqdescriptioin(String eqdescriptioin) {
        this.eqdescriptioin = eqdescriptioin;
    }

    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    public Long getAplyseq() {
        return this.aplyseq;
    }
    
    public void setAplyseq(Long aplyseq) {
        this.aplyseq = aplyseq;
    }

    public String getPerform() {
        return this.perform;
    }
    
    public void setPerform(String perform) {
        this.perform = perform;
    }
   








}