package no.sba.palindromapi.data.api;

public class PersonDto {

    private String fornavn;
    private boolean erFornavnPalindrom;
    private String etternavn;
    private boolean erEtternavnPalindrom;

    public PersonDto(String fornavn, boolean erFornavnPalindrom, String etternavn, boolean erEtternavnPalindrom) {
        super();
        this.fornavn = fornavn;
        this.erFornavnPalindrom = erFornavnPalindrom;
        this.etternavn = etternavn;
        this.erEtternavnPalindrom = erEtternavnPalindrom;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public boolean isErFornavnPalindrom() {
        return erFornavnPalindrom;
    }

    public void setErFornavnPalindrom(boolean erFornavnPalindrom) {
        this.erFornavnPalindrom = erFornavnPalindrom;
    }

    public boolean isErEtternavnPalindrom() {
        return erEtternavnPalindrom;
    }

    public void setErEtternavnPalindrom(boolean erEtternavnPalindrom) {
        this.erEtternavnPalindrom = erEtternavnPalindrom;
    }
}
