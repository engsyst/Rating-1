package ua.nure.indplan.excel.parser.entity;

public abstract class EntityWithHours {

    private int lectureHours;
    private int practicalTypeHours;
    private int laboratoryHours;
    private int consultationHours;
    private int kpkrHours;
    private int controleWorksHours;
    private int semesterControlHours;
    private int diplomHours;
    private int ekHours;
    private int aspirantHours;
    private int magisterHours;
    private int practiceHours;
    private int totalHours;

    public int getLectureHours() {
        return lectureHours;
    }

    public EntityWithHours setLectureHours(int lectureHours) {
        this.lectureHours = lectureHours;
        return this;
    }

    public int getPracticalTypeHours() {
        return practicalTypeHours;
    }

    public EntityWithHours setPracticalTypeHours(int practicalTypeHours) {
        this.practicalTypeHours = practicalTypeHours;
        return this;
    }

    public int getLaboratoryHours() {
        return laboratoryHours;
    }

    public EntityWithHours setLaboratoryHours(int laboratoryHours) {
        this.laboratoryHours = laboratoryHours;
        return this;
    }

    public int getConsultationHours() {
        return consultationHours;
    }

    public EntityWithHours setConsultationHours(int consultationHours) {
        this.consultationHours = consultationHours;
        return this;
    }

    public int getKpkrHours() {
        return kpkrHours;
    }

    public EntityWithHours setKpkrHours(int kpkrHours) {
        this.kpkrHours = kpkrHours;
        return this;
    }

    public int getControleWorksHours() {
        return controleWorksHours;
    }

    public EntityWithHours setControleWorksHours(int controleWorksHours) {
        this.controleWorksHours = controleWorksHours;
        return this;
    }

    public int getSemesterControlHours() {
        return semesterControlHours;
    }

    public EntityWithHours setSemesterControlHours(int semesterControlHours) {
        this.semesterControlHours = semesterControlHours;
        return this;
    }

    public int getDiplomHours() {
        return diplomHours;
    }

    public EntityWithHours setDiplomHours(int diplomHours) {
        this.diplomHours = diplomHours;
        return this;
    }

    public int getEkHours() {
        return ekHours;
    }

    public EntityWithHours setEkHours(int ekHours) {
        this.ekHours = ekHours;
        return this;
    }

    public int getAspirantHours() {
        return aspirantHours;
    }

    public EntityWithHours setAspirantHours(int aspirantHours) {
        this.aspirantHours = aspirantHours;
        return this;
    }

    public int getMagisterHours() {
        return magisterHours;
    }

    public EntityWithHours setMagisterHours(int magisterHours) {
        this.magisterHours = magisterHours;
        return this;
    }

    public int getPracticeHours() {
        return practiceHours;
    }

    public EntityWithHours setPracticeHours(int practiceHours) {
        this.practiceHours = practiceHours;
        return this;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public EntityWithHours setTotalHours(int totalHours) {
        this.totalHours = totalHours;
        return this;
    }
}
