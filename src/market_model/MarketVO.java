package market_model;

public class MarketVO implements java.io.Serializable {
    private Integer market_id;
    private String market_description;
    private byte[] market_img;
    private String market_location;
    private java.sql.Timestamp market_start;
    private java.sql.Timestamp market_end;
    private Integer market_fee;
    private Integer applicant_population;
    private Integer applicant_limit;
    private java.sql.Timestamp start_date;
    private java.sql.Timestamp end_date;

    public Integer getMarket_id() {
        return market_id;
    }

    public void setMarket_id(Integer market_id) {
        this.market_id = market_id;
    }

    public String getMarket_description() {
        return market_description;
    }

    public void setMarket_description(String market_description) {
        this.market_description = market_description;
    }

    public byte[] getMarket_img() {
        return market_img;
    }

    public void setMarket_img(byte[] market_img) {
        this.market_img = market_img;
    }

    public String getMarket_location() {
        return market_location;
    }

    public void setMarket_location(String market_location) {
        this.market_location = market_location;
    }

    public java.sql.Timestamp getMarket_start() {
        return market_start;
    }

    public void setMarket_start(java.sql.Timestamp market_start) {
        this.market_start = market_start;
    }

    public java.sql.Timestamp getMarket_end() {
        return market_end;
    }

    public void setMarket_end(java.sql.Timestamp market_end) {
        this.market_end = market_end;
    }

    public Integer getMarket_fee() {
        return market_fee;
    }

    public void setMarket_fee(Integer market_fee) {
        this.market_fee = market_fee;
    }

    public Integer getApplicant_population() {
        return applicant_population;
    }

    public void setApplicant_population(Integer applicant_population) {
        this.applicant_population = applicant_population;
    }

    public Integer getApplicant_limit() {
        return applicant_limit;
    }

    public void setApplicant_limit(Integer applicant_limit) {
        this.applicant_limit = applicant_limit;
    }

    public java.sql.Timestamp getStart_date() {
        return start_date;
    }

    public void setStart_date(java.sql.Timestamp start_date) {
        this.start_date = start_date;
    }

    public java.sql.Timestamp getEnd_date() {
        return end_date;
    }

    public void setEnd_date(java.sql.Timestamp end_date) {
        this.end_date = end_date;
    }
}
