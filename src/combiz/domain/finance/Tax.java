package combiz.domain.finance;



/**
 * Tax generated by MyEclipse - Hibernate Tools
 */

public class Tax  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String taxcode;
     private Double taxrate;
     private String typecode;


    // Constructors

    /** default constructor */
    public Tax() {
    }

    
    /** full constructor */
    public Tax(String taxcode, Double taxrate, String typecode) {
        this.taxcode = taxcode;
        this.taxrate = taxrate;
        this.typecode = typecode;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getTaxcode() {
        return this.taxcode;
    }
    
    public void setTaxcode(String taxcode) {
        this.taxcode = taxcode;
    }

    public Double getTaxrate() {
        return this.taxrate;
    }
    
    public void setTaxrate(Double taxrate) {
        this.taxrate = taxrate;
    }

    public String getTypecode() {
        return this.typecode;
    }
    
    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }
   








}