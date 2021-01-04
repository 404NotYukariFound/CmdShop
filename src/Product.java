public class Product {
    private String pId;
    private String pName;
    private String Price;
    private String pDescr;
    private int ShangPinShuLiang=0;

    public void setpId(String pId) {
        this.pId = pId;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public void setpDescr(String pDescr) {
        this.pDescr = pDescr;
    }

    public void setShangPinShuLiang(int shangPinShuLiang) {
        ShangPinShuLiang = shangPinShuLiang;
    }

    public String getpId() {
        return pId;
    }

    public String getpName() {
        return pName;
    }

    public String getPrice() {
        return Price;
    }

    public String getpDescr() {
        return pDescr;
    }

    public int getShangPinShuLiang() {
        return ShangPinShuLiang;
    }
}
