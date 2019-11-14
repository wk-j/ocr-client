package wk;

class Profile {
    private String profile;
    private double x;
    private double y;
    private double width;
    private double height;

    public String getProfile() {
        return profile;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}