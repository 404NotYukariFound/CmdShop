public class User {
    private String username;
    private String password;
    private String address;
    private String phone;
    void setUsername(String username)
    {
        this.username=username;
    }
    void setPassword(String password)
    {
        this.password=password;
    }
    void setAddress(String address)
    {
        this.address=address;
    }
    void setPhone(String phone)
    {
        this.phone=phone;
    }
    String getUsername()
    {
        return this.username;
    }
    String getPassword()
    {
        return this.password;
    }
    String getAddress()
    {
        return this.address;
    }
    String getPhone()
    {
        return this.phone;
    }
}
