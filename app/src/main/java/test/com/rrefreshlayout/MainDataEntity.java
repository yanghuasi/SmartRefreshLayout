package test.com.rrefreshlayout;

public class MainDataEntity {
    private String view;
    private String viewTwo;
    private String viewThree;
    private String viewFour;

    public MainDataEntity(String view, String viewTwo, String viewThree, String viewFour) {
        this.view = view;
        this.viewTwo = viewTwo;
        this.viewThree = viewThree;
        this.viewFour = viewFour;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getViewTwo() {
        return viewTwo;
    }

    public void setViewTwo(String viewTwo) {
        this.viewTwo = viewTwo;
    }

    public String getViewThree() {
        return viewThree;
    }

    public void setViewThree(String viewThree) {
        this.viewThree = viewThree;
    }

    public String getViewFour() {
        return viewFour;
    }

    public void setViewFour(String viewFour) {
        this.viewFour = viewFour;
    }
}
