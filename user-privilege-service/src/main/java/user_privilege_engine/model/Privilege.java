package user_privilege_engine.model;

class Privilege {
    private Boolean showAds;
    private Boolean showPremium;

    private Privilege(boolean showAds, boolean showPremium) {
        this.showAds = showAds;
        this.showPremium = showPremium;
    }

    static Privilege getInstance(String status) {
        if (status != null && status.equals("active")) {
            return new Privilege(false, true);
        } else {
            return new Privilege(true, false);
        }
    }

    public Boolean getShowAds() {
        return showAds;
    }

    public Boolean getShowPremium() {
        return showPremium;
    }
}
